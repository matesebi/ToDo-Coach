package hu.aut.bme.matesebi.todocoach.interactor.list

import hu.aut.bme.matesebi.todocoach.db.TodoDao
import hu.aut.bme.matesebi.todocoach.model.DummyContent
import hu.aut.bme.matesebi.todocoach.network.TodoApi
import javax.inject.Inject

class ListInteractor @Inject constructor(todoApi: TodoApi, todoDao: TodoDao) {
    fun getItems(): List<DummyContent> {
        return emptyList()
    }
}