package hu.aut.bme.matesebi.todocoach.interactor.list

import android.util.Log
import hu.aut.bme.matesebi.todocoach.db.TodoDao
import hu.aut.bme.matesebi.todocoach.model.Task
import hu.aut.bme.matesebi.todocoach.network.TodoApi
import javax.inject.Inject

class ListInteractor @Inject constructor(private val todoApi: TodoApi, private val todoDao: TodoDao) {
    private val authorization = "Bearer df1f3d82f913d6f725dea3a2e4e35cc7d112b307"
    suspend fun getItems(): List<Task> {
        return try {
            val tasks = todoApi.getTasks(authorization)
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
        todoApi.closeTask(authorization, task.id.toString())
    }

    suspend fun createTask(task: Task) {
        todoApi.createTask(authorization, task)
    }
}