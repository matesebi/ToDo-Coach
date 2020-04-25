package hu.aut.bme.matesebi.todocoach.db.converters

import androidx.room.TypeConverter

class IntListConverter {

    @TypeConverter
    fun intListToString(value: List<Int>?): String? {
        return value?.joinToString(",")
    }

    @TypeConverter
    fun stringToIntList(value: String?): List<Int>? {
        return value?.split(",")?.map { it.toInt() }
    }
}