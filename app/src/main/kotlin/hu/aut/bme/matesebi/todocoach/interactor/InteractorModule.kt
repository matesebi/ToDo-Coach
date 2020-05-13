package hu.aut.bme.matesebi.todocoach.interactor

import dagger.Module
import dagger.Provides
import hu.aut.bme.matesebi.todocoach.db.TodoDao
import hu.aut.bme.matesebi.todocoach.interactor.detail.DetailInteractor
import hu.aut.bme.matesebi.todocoach.interactor.list.ListInteractor
import hu.aut.bme.matesebi.todocoach.interactor.user.UserInteractor
import hu.aut.bme.matesebi.todocoach.network.OAuthApi
import hu.aut.bme.matesebi.todocoach.network.TodoApi
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun provideUserInteractor(oAuthApi: OAuthApi) = UserInteractor(oAuthApi)

    @Provides
    @Singleton
    fun provideListInteractor(todoApi: TodoApi, todoDao: TodoDao, userInteractor: UserInteractor) = ListInteractor(todoApi, todoDao, userInteractor)

    @Provides
    @Singleton
    fun provideDetailInteractor(todoApi: TodoApi, todoDao: TodoDao, userInteractor: UserInteractor) = DetailInteractor(todoApi, todoDao, userInteractor)

}