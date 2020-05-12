package hu.aut.bme.matesebi.todocoach.interactor.detail

import hu.aut.bme.matesebi.todocoach.db.TodoDao
import hu.aut.bme.matesebi.todocoach.model.Task
import hu.aut.bme.matesebi.todocoach.network.TodoApi
import javax.inject.Inject

class DetailInteractor @Inject constructor(val todoApi: TodoApi, todoDao: TodoDao) {
    private val authorization = "Bearer df1f3d82f913d6f725dea3a2e4e35cc7d112b307"
    suspend fun getDetails(taskId: Long): Task {
        return todoApi.getTask(authorization, taskId)
    }

    suspend fun completeTask(task: Task) {
        todoApi.closeTask(authorization, task.id.toString())
    }
}