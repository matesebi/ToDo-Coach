package hu.aut.bme.matesebi.todocoach

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import hu.aut.bme.matesebi.todocoach.ui.UIModule
import javax.inject.Inject

class ToDoApplication : Application(){
    lateinit var injector: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}