package hu.aut.bme.matesebi.todocoach.interactor.list

import android.util.Log
import hu.aut.bme.matesebi.todocoach.db.TodoDao
import hu.aut.bme.matesebi.todocoach.interactor.user.UserInteractor
import hu.aut.bme.matesebi.todocoach.model.Task
import hu.aut.bme.matesebi.todocoach.network.TodoApi
import javax.inject.Inject

class ListInteractor @Inject constructor(private val todoApi: TodoApi, private val todoDao: TodoDao, private val userInteractor: UserInteractor) {

    private suspend fun getAuthorization() = userInteractor.getAuthorization()

    suspend fun getItems(): List<Task> {
        return try {
            val tasks = todoApi.getTasks(getAuthorization())
            tasks.forEach {
                Log.d("load_tasks", "Task loaded: $it")
            }
            tasks
        }catch (e: Error) {
            Log.e("network", "getItems Failed", e)
            emptyList()
        }
    }

    suspend fun completeTask(task: Task) {
        todoApi.closeTask(getAuthorization(), task.id.toString())
    }

    suspend fun createTask(task: Task) {
        todoApi.createTask(getAuthorization(), task)
    }
}