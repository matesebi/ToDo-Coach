package hu.aut.bme.matesebi.todocoach.ui.detail

import hu.aut.bme.matesebi.todocoach.model.Task

interface DetailScreen {
    fun showDetails(task: Task)
    fun navigateBack()
}