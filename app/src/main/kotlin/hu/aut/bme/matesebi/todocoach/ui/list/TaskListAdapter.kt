package hu.aut.bme.matesebi.todocoach.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hu.aut.bme.matesebi.todocoach.R
import hu.aut.bme.matesebi.todocoach.model.Task
import kotlinx.android.synthetic.main.todo_row.view.*

class TaskListAdapter(private val listener: Listener)
    : ListAdapter<Task, TaskListAdapter.TodoViewHolder>(TaskComparator()) {
    interface Listener {
        fun onTaskClicked(task: Task)
        fun onTaskCompleted(task: Task)
    }

    inner class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val todoNameText: TextView = view.todoNameText
        val todoCheckbox: CheckBox = view.todoCheckbox

        var task: Task? = null

        init {
            view.setOnClickListener {
                task?.let { listener.onTaskClicked(it) }
            }
            todoCheckbox.setOnClickListener {
                task?.let { listener.onTaskCompleted(it) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_row, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val task = getItem(position)
        holder.task = task
        holder.todoNameText.text = task.content
        holder.todoCheckbox.isChecked = task.completed ?: false
    }
}