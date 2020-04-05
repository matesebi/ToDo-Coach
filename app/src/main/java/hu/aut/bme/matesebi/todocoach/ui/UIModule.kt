package hu.aut.bme.matesebi.todocoach.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.aut.bme.matesebi.todocoach.interactor.detail.DetailInteractor
import hu.aut.bme.matesebi.todocoach.interactor.list.ListInteractor
import hu.aut.bme.matesebi.todocoach.ui.detail.DetailPresenter
import hu.aut.bme.matesebi.todocoach.ui.list.ListPresenter
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun listPresenter(listInteractor: ListInteractor) = ListPresenter(listInteractor)

    @Provides
    @Singleton
    fun detailPresenter(detailInteractor: DetailInteractor) = DetailPresenter(detailInteractor)

}
