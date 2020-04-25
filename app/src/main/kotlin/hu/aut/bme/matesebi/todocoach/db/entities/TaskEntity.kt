package hu.aut.bme.matesebi.todocoach.db.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val projectId: Int,
    val sectionId: Int,
    val content: String,
    val completed: Boolean,
    val labelIds: List<Int>,
    val parent: Int,
    val order: Int,
    val priority: Int,
    @Embedded
    val due: Due,
    val url: String,
    val commentCount: Int
)