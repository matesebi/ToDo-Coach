package hu.aut.bme.matesebi.todocoach.ui.list

import hu.aut.bme.matesebi.todocoach.interactor.list.ListInteractor
import hu.aut.bme.matesebi.todocoach.model.Due
import hu.aut.bme.matesebi.todocoach.model.DummyContent
import hu.aut.bme.matesebi.todocoach.model.Task
import hu.aut.bme.matesebi.todocoach.ui.Presenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.stream.Stream

class ListPresenter constructor(private val interactor: ListInteractor) : Presenter<ListScreen>() {

    suspend fun completeTask(task: Task) = withContext(Dispatchers.IO) {
        interactor.completeTask(task)
        refreshList()
    }

    suspend fun refreshList() = withContext(Dispatchers.IO) {
        screen?.showItems(interactor.getItems())
    }

    suspend fun createTask(content: String, priority: Int, dueDate: String) = withContext(Dispatchers.IO) {
        val task = Task(content = content, priority = priority, due = Due(date = dueDate))
        interactor.createTask(task)
        refreshList()
    }
}