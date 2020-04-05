package hu.aut.bme.matesebi.todocoach

import android.app.Activity
import androidx.fragment.app.Fragment

val Activity.injector: ApplicationComponent
    get() = (this.applicationContext as ToDoApplication).injector

val Fragment.injector: ApplicationComponent
    get() = (this.context!!.applicationContext as ToDoApplication).injector