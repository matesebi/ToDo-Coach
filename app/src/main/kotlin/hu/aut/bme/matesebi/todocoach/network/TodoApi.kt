package hu.aut.bme.matesebi.todocoach.network

import hu.aut.bme.matesebi.todocoach.model.Project
import hu.aut.bme.matesebi.todocoach.model.Section
import hu.aut.bme.matesebi.todocoach.model.Task
import retrofit2.http.*

interface TodoApi {

    @GET("/projects")
    fun getProjects(
        @Header("Authorization") authorization: String
    ): List<Project>

    @POST("/projects")
    fun createNewProject(
        @Header("Authorization") authorization: String,
        @Body project: Project
    ): Project
    
    @GET("/projects/{projectId}")
    fun getProject(
        @Header("Authorization") authorization: String,
        @Path("projectId") id: String
    ): Project

    @POST("/projects/{projectId}")
    fun updateProject(
        @Header("Authorization") authorization: String,
        @Path("projectId") id: String,
        @Body project: Project
    )

    @DELETE("/projects/{projectId}")
    fun deleteProject(
        @Header("Authorization") authorization: String,
        @Path("projectId") id: String
    )

    @GET("/sections")
    fun getSections(
        @Header("Authorization") authorization: String
    ): List<Section>

    @POST("/sections")
    fun createSection(
        @Header("Authorization") authorization: String,
        @Body section: Section
    ): Section

    @GET("/sections{sectionId}")
    fun getSection(
        @Header("Authorization") authorization: String,
        @Path("sectionId") id: String
    ): Section

    @POST("/sections{sectionId}")
    fun updateSection(
        @Header("Authorization") authorization: String,
        @Path("sectionId") id: String,
        @Body section: Section
    )

    @DELETE("/sections{sectionId}")
    fun deleteSection(
        @Header("Authorization") authorization: String,
        @Path("sectionId") id: String
    )

    @GET("/tasks")
    fun getTasks(
        @Header("Authorization") authorization: String,
        @Query("project_id") project_id: String
    ): List<Task>

    @POST("/tasks")
    fun createTask(
        @Header("Authorization") authorization: String,
        @Body task: Task
    ): Task

    @GET("/tasks/{taskId}")
    fun getTask(
        @Header("Authorization") authorization: String,
        @Path("taskId") id: String
    ): Section

    @POST("/tasks/{taskId}")
    fun updateTask(
        @Header("Authorization") authorization: String,
        @Path("taskId") id: String,
        @Body task: Task
    )

    @DELETE("/tasks/{taskId}")
    fun deleteTask(
        @Header("Authorization") authorization: String,
        @Path("taskId") id: String
    )

    @POST("/tasks/{taskId}/close")
    fun closeTask(
        @Header("Authorization") authorization: String,
        @Path("taskId") id: String
    )

    @POST("/tasks/{taskId}/reopen")
    fun reopenTask(
        @Header("Authorization") authorization: String,
        @Path("taskId") id: String
    )
}