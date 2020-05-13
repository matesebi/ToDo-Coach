package hu.aut.bme.matesebi.todocoach

import hu.aut.bme.matesebi.todocoach.interactor.detail.DetailInteractor
import hu.aut.bme.matesebi.todocoach.model.Task
import hu.aut.bme.matesebi.todocoach.ui.detail.DetailPresenter
import hu.aut.bme.matesebi.todocoach.ui.detail.DetailScreen
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class DetailPresenterTest {

    private var icCounter: Long = 1

    private lateinit var detailPresenter: DetailPresenter

    private lateinit var detailInteractor: DetailInteractor
    private lateinit var detailScreen: DetailScreen

    @Before
    fun setUp() {
        detailInteractor = mockk(relaxed = true)
        detailScreen = mockk(relaxed = true)

        detailPresenter = DetailPresenter(detailInteractor)
        detailPresenter.attachScreen(detailScreen)
        clearAllMocks()
    }

    @Test
    fun showDetails() = runBlocking {
        val mockId = getNextMockId()
        val task = Task(id = mockId)

        detailPresenter.showDetails(task)

        verify { detailScreen.showDetails(task) }
        confirmVerified(detailScreen)
    }

    @Test
    fun completeTask() = runBlocking {
        val mockId = getNextMockId()
        val task = Task(id = mockId)

        detailPresenter.completeTask(task)

        coVerify { detailInteractor.completeTask(task) }
        verify { detailScreen.navigateBack() }
        confirmVerified(detailInteractor)
        confirmVerified(detailScreen)
    }

    @Test
    fun getDetails() = runBlocking {
        val mockId = getNextMockId()
        coEvery { detailInteractor.getDetails(mockId) } returns Task(id = mockId)

        detailPresenter.getDetails(mockId)

        coVerify { detailInteractor.getDetails(mockId) }
        verify { detailScreen.showDetails(any()) }
        confirmVerified(detailInteractor)
        confirmVerified(detailScreen)
    }

    private fun getNextMockId(): Long {
        return icCounter++
    }
}