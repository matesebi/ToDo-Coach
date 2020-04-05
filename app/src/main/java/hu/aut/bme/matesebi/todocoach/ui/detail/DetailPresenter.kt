package hu.aut.bme.matesebi.todocoach.ui.detail

import hu.aut.bme.matesebi.todocoach.interactor.detail.DetailInteractor
import hu.aut.bme.matesebi.todocoach.model.DummyContent
import hu.aut.bme.matesebi.todocoach.ui.Presenter

class DetailPresenter constructor(private val interactor: DetailInteractor): Presenter<DetailScreen>() {
    fun showDetails(item: DummyContent) {
        this.screen?.showDetails(item)
    }

    fun getDetails(item: DummyContent) {
        showDetails(interactor.getDetails(item))
    }
}