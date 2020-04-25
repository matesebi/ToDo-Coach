package hu.aut.bme.matesebi.todocoach

import android.app.Application
import hu.aut.bme.matesebi.todocoach.ui.UIModule

class ToDoApplication : Application(){
    lateinit var injector: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}