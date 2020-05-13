package hu.aut.bme.matesebi.todocoach

import hu.aut.bme.matesebi.todocoach.interactor.list.ListInteractor
import hu.aut.bme.matesebi.todocoach.model.Task
import hu.aut.bme.matesebi.todocoach.ui.list.ListPresenter
import hu.aut.bme.matesebi.todocoach.ui.list.ListScreen
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ListPresenterTest {

    private var icCounter: Long = 1

    private lateinit var listPresenter: ListPresenter

    private lateinit var interactor: ListInteractor
    private lateinit var screen: ListScreen

    @Before
    fun setUp() {
        interactor = mockk(relaxed = true)
        screen = mockk(relaxed = true)
        listPresenter = ListPresenter(interactor)
        listPresenter.attachScreen(screen)
        clearAllMocks()
    }

    @Test
    fun completeTask() = runBlocking {
        val mockId = getNextMockId()
        val task = Task(id = mockId)
        coEvery { interactor.getItems() } returns emptyList()

        listPresenter.completeTask(task)

        coVerify { interactor.completeTask(task) }
        coVerify { interactor.getItems() }
        verify { screen.showItems(any()) }
        confirmVerified(interactor)
        confirmVerified(screen)
    }

    @Test
    fun refreshList() = runBlocking {
        coEvery { interactor.getItems() } returns emptyList()

        listPresenter.refreshList()

        coVerify { interactor.getItems() }
        verify { screen.showItems(any()) }
        confirmVerified(interactor)
        confirmVerified(screen)
    }

    @Test
    fun createTask() = runBlocking {
        val mockId = getNextMockId()
        val task = Task(id = mockId)
        coEvery { interactor.getItems() } returns emptyList()

        listPresenter.createTask("UI tests", 4, "2020-05-15")

        coVerify { interactor.createTask(any()) }
        coVerify { interactor.getItems() }
        verify { screen.showItems(any()) }
        confirmVerified(interactor)
        confirmVerified(screen)
    }

    private fun getNextMockId(): Long {
        return icCounter++
    }
}