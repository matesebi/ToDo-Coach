package hu.aut.bme.matesebi.todocoach

import hu.aut.bme.matesebi.todocoach.db.TodoDao
import hu.aut.bme.matesebi.todocoach.interactor.detail.DetailInteractor
import hu.aut.bme.matesebi.todocoach.interactor.user.UserInteractor
import hu.aut.bme.matesebi.todocoach.model.Task
import hu.aut.bme.matesebi.todocoach.network.TodoApi
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class DetailInteractorTest {

    private var icCounter: Long = 1

    private lateinit var detailInteractor: DetailInteractor

    private lateinit var todoApi: TodoApi
    private lateinit var todoDao: TodoDao
    private lateinit var userInteractor: UserInteractor

    @Before
    fun setUp() {
        todoApi = mockk(relaxed = true)
        todoDao = mockk(relaxed = true)
        userInteractor = mockk(relaxed = true)

        detailInteractor = DetailInteractor(todoApi, todoDao, userInteractor)

        clearAllMocks()
    }

    @Test
    fun getDetails() = runBlocking {
        val mockId = getNextMockId()
        coEvery { userInteractor.getAuthorization() } returns "Bearer fake-token"
        coEvery { todoApi.getTask(any(), any()) } returns Task(id = mockId)

        detailInteractor.getDetails(mockId)

        coVerify { userInteractor.getAuthorization() }
        coVerify { todoApi.getTask(any(), mockId) }
        confirmVerified(userInteractor)
        confirmVerified(todoApi)

    }

    @Test
    fun completeTask() = runBlocking {
        val mockId = getNextMockId()
        val task = Task(id = mockId)
        coEvery { userInteractor.getAuthorization() } returns "Bearer fake-token"

        detailInteractor.completeTask(task)

        coVerify { userInteractor.getAuthorization() }
        coVerify { todoApi.closeTask(any(), task.id.toString()) }
        confirmVerified(userInteractor)
        confirmVerified(todoApi)
    }

    private fun getNextMockId(): Long {
        return icCounter++
    }
}