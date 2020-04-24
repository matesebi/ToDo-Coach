package hu.aut.bme.matesebi.todocoach.ui.list

import hu.aut.bme.matesebi.todocoach.interactor.list.ListInteractor
import hu.aut.bme.matesebi.todocoach.ui.Presenter
import hu.aut.bme.matesebi.todocoach.model.DummyContent

class ListPresenter constructor(private val interactor: ListInteractor): Presenter<ListScreen>() {
    fun showItems(items: List<DummyContent>) {
        this.screen?.showItems(items)
    }

    fun refreshList(){
        showItems(interactor.getItems())
    }
}