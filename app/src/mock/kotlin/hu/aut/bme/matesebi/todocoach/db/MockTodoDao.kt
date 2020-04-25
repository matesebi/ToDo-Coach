package hu.aut.bme.matesebi.todocoach.db

import hu.aut.bme.matesebi.todocoach.db.entities.ProjectEntity
import hu.aut.bme.matesebi.todocoach.db.entities.TaskEntity

class MockTodoDao: TodoDao {
    override fun getAllProjects(): List<ProjectEntity> {
        TODO("Not yet implemented")
    }

    override fun addProject(projectEntity: ProjectEntity) {
        TODO("Not yet implemented")
    }

    override fun getAllTasks(): List<ProjectEntity> {
        TODO("Not yet implemented")
    }

    override fun addTask(taskEntity: TaskEntity) {
        TODO("Not yet implemented")
    }

}