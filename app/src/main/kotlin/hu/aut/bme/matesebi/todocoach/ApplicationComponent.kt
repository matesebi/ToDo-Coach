package hu.aut.bme.matesebi.todocoach

import dagger.Component
import dagger.Subcomponent
import hu.aut.bme.matesebi.todocoach.interactor.InteractorModule
import hu.aut.bme.matesebi.todocoach.ui.UIModule
import hu.aut.bme.matesebi.todocoach.ui.detail.ItemDetailActivity
import hu.aut.bme.matesebi.todocoach.ui.list.ItemListActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, InteractorModule::class])
interface ApplicationComponent {
    fun inject(itemListActivity: ItemListActivity)
    fun inject(itemDetailActivity: ItemDetailActivity)
}