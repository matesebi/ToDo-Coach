package hu.aut.bme.matesebi.todocoach.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import hu.aut.bme.matesebi.todocoach.db.entities.ProjectEntity
import hu.aut.bme.matesebi.todocoach.db.entities.TaskEntity


@Database(
    exportSchema = false,
    version = 1,
    entities = [
        ProjectEntity::class,
        TaskEntity::class
    ]
)
@TypeConverters(
    IntListConverter::class
)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao

}