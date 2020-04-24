package hu.aut.bme.matesebi.todocoach.ui.list

import hu.aut.bme.matesebi.todocoach.model.DummyContent

interface ListScreen {
    fun showItems(items: List<DummyContent>)
}