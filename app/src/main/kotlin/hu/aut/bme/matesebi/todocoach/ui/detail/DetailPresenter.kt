package hu.aut.bme.matesebi.todocoach.ui.detail

import hu.aut.bme.matesebi.todocoach.interactor.detail.DetailInteractor
import hu.aut.bme.matesebi.todocoach.model.DummyContent
import hu.aut.bme.matesebi.todocoach.model.Task
import hu.aut.bme.matesebi.todocoach.ui.Presenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DetailPresenter constructor(private val interactor: DetailInteractor): Presenter<DetailScreen>() {
    fun showDetails(task: Task) {
        this.screen?.showDetails(task)
    }

    suspend fun completeTask(task: Task) = withContext(Dispatchers.IO) {
        interactor.completeTask(task)
        screen?.navigateBack()
    }

    suspend fun getDetails(taskId: Long) {
        showDetails(interactor.getDetails(taskId))
    }
}