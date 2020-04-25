package hu.aut.bme.matesebi.todocoach.interactor.detail

import hu.aut.bme.matesebi.todocoach.db.TodoDao
import hu.aut.bme.matesebi.todocoach.model.DummyContent
import hu.aut.bme.matesebi.todocoach.network.TodoApi
import javax.inject.Inject

class DetailInteractor @Inject constructor(todoApi: TodoApi, todoDao: TodoDao) {
    fun getDetails(item: DummyContent): DummyContent {
        return item
    }
}