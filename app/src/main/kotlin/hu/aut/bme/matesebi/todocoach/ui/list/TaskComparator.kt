package hu.aut.bme.matesebi.todocoach.ui.list

import androidx.recyclerview.widget.DiffUtil
import hu.aut.bme.matesebi.todocoach.model.Task

class TaskComparator: DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }
}