package hu.aut.bme.matesebi.todocoach.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import hu.aut.bme.matesebi.todocoach.db.entities.ProjectEntity
import hu.aut.bme.matesebi.todocoach.db.entities.TaskEntity

@Dao
interface TodoDao {
    @Query("SELECT * FROM projects")
    fun getAllProjects(): List<ProjectEntity>

    @Insert(onConflict = REPLACE)
    fun addProject(projectEntity: ProjectEntity)

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): List<TaskEntity>

    @Insert(onConflict = REPLACE)
    fun addTask(taskEntity: TaskEntity)

}