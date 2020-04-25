package hu.aut.bme.matesebi.todocoach.db

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockDBModule {
    @Provides
    @Singleton
    fun provideTodoDao(): TodoDao = MockTodoDao()
}