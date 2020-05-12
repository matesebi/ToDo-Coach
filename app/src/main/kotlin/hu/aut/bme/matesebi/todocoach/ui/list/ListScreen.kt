package hu.aut.bme.matesebi.todocoach.ui.list

import androidx.annotation.UiThread
import hu.aut.bme.matesebi.todocoach.model.Task

interface ListScreen {

    @UiThread
    fun showItems(items: List<Task>)
}