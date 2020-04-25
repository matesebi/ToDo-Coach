package hu.aut.bme.matesebi.todocoach.interactor

import dagger.Module
import dagger.Provides
import hu.aut.bme.matesebi.todocoach.db.TodoDao
import hu.aut.bme.matesebi.todocoach.interactor.detail.DetailInteractor
import hu.aut.bme.matesebi.todocoach.interactor.list.ListInteractor
import hu.aut.bme.matesebi.todocoach.network.TodoApi
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideListInteractor(todoApi: TodoApi, todoDao: TodoDao) = ListInteractor(todoApi, todoDao)

    @Provides
    @Singleton
    fun provideDetailInteractor(todoApi: TodoApi, todoDao: TodoDao) = DetailInteractor(todoApi, todoDao)

}