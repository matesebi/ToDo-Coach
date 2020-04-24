package hu.aut.bme.matesebi.todocoach.interactor

import dagger.Module
import dagger.Provides
import hu.aut.bme.matesebi.todocoach.interactor.detail.DetailInteractor
import hu.aut.bme.matesebi.todocoach.interactor.list.ListInteractor
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideListInteractor() = ListInteractor()

    @Provides
    @Singleton
    fun provideDetailInteractor() = DetailInteractor()

}