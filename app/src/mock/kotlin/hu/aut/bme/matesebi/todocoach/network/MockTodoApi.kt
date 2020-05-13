package hu.aut.bme.matesebi.todocoach.network

import hu.aut.bme.matesebi.todocoach.model.Project
import hu.aut.bme.matesebi.todocoach.model.Section
import hu.aut.bme.matesebi.todocoach.model.Task
import retrofit2.Response

class MockTodoApi: TodoApi {
    override suspend fun getProjects(authorization: String): List<Project> {
        TODO("Not yet implemented")
    }

    override suspend fun getTasks(authorization: String): List<Task> {
        TODO("Not yet implemented")
    }

    override suspend fun createTask(authorization: String, task: Task, content_type: String): Response<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun getTask(authorization: String, id: Long): Task {
        TODO("Not yet implemented")
    }

    override suspend fun closeTask(authorization: String, id: String): Response<Unit> {
        TODO("Not yet implemented")
    }

}