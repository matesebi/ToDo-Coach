package hu.aut.bme.matesebi.todocoach.interactor.detail

import hu.aut.bme.matesebi.todocoach.db.TodoDao
import hu.aut.bme.matesebi.todocoach.interactor.user.UserInteractor
import hu.aut.bme.matesebi.todocoach.model.Task
import hu.aut.bme.matesebi.todocoach.network.TodoApi
import javax.inject.Inject

class DetailInteractor @Inject constructor(
    val todoApi: TodoApi,
    todoDao: TodoDao,
    private val userInteractor: UserInteractor
) {
    private suspend fun getAuthorization() = userInteractor.getAuthorization()

    suspend fun getDetails(taskId: Long): Task {
        return todoApi.getTask(getAuthorization(), taskId)
    }

    suspend fun completeTask(task: Task) {
        todoApi.closeTask(getAuthorization(), task.id.toString())
    }
}