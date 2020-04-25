package hu.aut.bme.matesebi.todocoach.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "projects")
data class ProjectEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val color: Int,
    val parent: Int?,
    val order: Int,
    val commentCount: String
)