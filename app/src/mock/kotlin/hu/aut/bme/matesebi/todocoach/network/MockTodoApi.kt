package hu.aut.bme.matesebi.todocoach.network

import hu.aut.bme.matesebi.todocoach.model.Project
import hu.aut.bme.matesebi.todocoach.model.Section
import hu.aut.bme.matesebi.todocoach.model.Task

class MockTodoApi: TodoApi {
    override fun getProjects(authorization: String): List<Project> {
        TODO("Not yet implemented")
    }

    override fun createNewProject(authorization: String, project: Project): Project {
        TODO("Not yet implemented")
    }

    override fun getProject(authorization: String, id: String): Project {
        TODO("Not yet implemented")
    }

    override fun updateProject(authorization: String, id: String, project: Project) {
        TODO("Not yet implemented")
    }

    override fun deleteProject(authorization: String, id: String) {
        TODO("Not yet implemented")
    }

    override fun getSections(authorization: String): List<Section> {
        TODO("Not yet implemented")
    }

    override fun createSection(authorization: String, section: Section): Section {
        TODO("Not yet implemented")
    }

    override fun getSection(authorization: String, id: String): Section {
        TODO("Not yet implemented")
    }

    override fun updateSection(authorization: String, id: String, section: Section) {
        TODO("Not yet implemented")
    }

    override fun deleteSection(authorization: String, id: String) {
        TODO("Not yet implemented")
    }

    override fun getTasks(authorization: String, project_id: String): List<Task> {
        TODO("Not yet implemented")
    }

    override fun createTask(authorization: String, task: Task): Task {
        TODO("Not yet implemented")
    }

    override fun getTask(authorization: String, id: String): Section {
        TODO("Not yet implemented")
    }

    override fun updateTask(authorization: String, id: String, task: Task) {
        TODO("Not yet implemented")
    }

    override fun deleteTask(authorization: String, id: String) {
        TODO("Not yet implemented")
    }

    override fun closeTask(authorization: String, id: String) {
        TODO("Not yet implemented")
    }

    override fun reopenTask(authorization: String, id: String) {
        TODO("Not yet implemented")
    }
}