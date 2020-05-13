package hu.aut.bme.matesebi.todocoach

import hu.aut.bme.matesebi.todocoach.db.TodoDao
import hu.aut.bme.matesebi.todocoach.interactor.detail.DetailInteractor
import hu.aut.bme.matesebi.todocoach.interactor.list.ListInteractor
import hu.aut.bme.matesebi.todocoach.interactor.user.UserInteractor
import hu.aut.bme.matesebi.todocoach.model.Task
import hu.aut.bme.matesebi.todocoach.network.TodoApi
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ListInteractorTest {

    private var icCounter: Long = 1

    private lateinit var listInteractor: ListInteractor

    private lateinit var todoApi: TodoApi
    private lateinit var todoDao: TodoDao
    private lateinit var userInteractor: UserInteractor

    @Before
    fun setUp() {
        todoApi = mockk(relaxed = true)
        todoDao = mockk(relaxed = true)
        userInteractor = mockk(relaxed = true)

        listInteractor = ListInteractor(todoApi, todoDao, userInteractor)

        clearAllMocks()
    }

    @Test
    fun getItems() = runBlocking {
        coEvery { userInteractor.getAuthorization() } returns "Bearer fake-token"
        coEvery { todoApi.getTasks(any()) } returns emptyList()

        listInteractor.getItems()

        coVerify { userInteractor.getAuthorization() }
        coVerify { todoApi.getTasks(any()) }
        confirmVerified(userInteractor)
        confirmVerified(todoApi)
    }

    @Test
    fun completeTask() = runBlocking {
        val mockId = getNextMockId()
        val task = Task(id = mockId)
        coEvery { userInteractor.getAuthorization() } returns "Bearer fake-token"

        listInteractor.completeTask(task)

        coVerify { userInteractor.getAuthorization() }
        coVerify { todoApi.closeTask(any(), task.id.toString()) }
        confirmVerified(userInteractor)
        confirmVerified(todoApi)
    }

    @Test
    fun createTask() = runBlocking {
        val mockId = getNextMockId()
        val task = Task(id = mockId)
        coEvery { userInteractor.getAuthorization() } returns "Bearer fake-token"

        listInteractor.createTask(task)

        coVerify { userInteractor.getAuthorization() }
        coVerify { todoApi.createTask(any(), task) }
        confirmVerified(userInteractor)
        confirmVerified(todoApi)
    }

    private fun getNextMockId(): Long {
        return icCounter++
    }
}