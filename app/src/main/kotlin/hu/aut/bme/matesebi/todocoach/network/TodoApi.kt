package hu.aut.bme.matesebi.todocoach.network

import hu.aut.bme.matesebi.todocoach.model.Project
import hu.aut.bme.matesebi.todocoach.model.Task
import retrofit2.Response
import retrofit2.http.*

interface TodoApi {

    @GET("rest/v1/projects")
    suspend fun getProjects(@Header("Authorization") authorization: String): List<Project>

    @GET("rest/v1/tasks")
    suspend fun getTasks(
        @Header("Authorization") authorization: String
    ): List<Task>

    @POST("rest/v1/tasks")
    suspend fun createTask(
        @Header("Authorization") authorization: String,
        @Body task: Task,
        @Header("Content-Type") content_type:String = "application/json"
    ): Response<Unit>

    @GET("rest/v1/tasks/{taskId}")
    suspend fun getTask(
        @Header("Authorization") authorization: String,
        @Path("taskId") id: Long
    ): Task

    @POST("rest/v1/tasks/{taskId}/close")
    suspend fun closeTask(
        @Header("Authorization") authorization: String,
        @Path("taskId") id: String
    ): Response<Unit>

}