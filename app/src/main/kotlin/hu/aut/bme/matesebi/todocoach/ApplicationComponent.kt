package hu.aut.bme.matesebi.todocoach

import dagger.Component
import hu.aut.bme.matesebi.todocoach.db.DBModule
import hu.aut.bme.matesebi.todocoach.interactor.InteractorModule
import hu.aut.bme.matesebi.todocoach.network.NetworkModule
import hu.aut.bme.matesebi.todocoach.ui.UIModule
import hu.aut.bme.matesebi.todocoach.ui.detail.ItemDetailActivity
import hu.aut.bme.matesebi.todocoach.ui.list.ItemListActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        DBModule::class,
        UIModule::class,
        InteractorModule::class
    ]
)
interface ApplicationComponent {
    fun inject(itemListActivity: ItemListActivity)
    fun inject(itemDetailActivity: ItemDetailActivity)
}