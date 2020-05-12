package hu.aut.bme.matesebi.todocoach.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RatingBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import hu.aut.bme.matesebi.todocoach.R
import hu.aut.bme.matesebi.todocoach.injector
import hu.aut.bme.matesebi.todocoach.model.Task
import hu.aut.bme.matesebi.todocoach.ui.detail.DetailPresenter
import hu.aut.bme.matesebi.todocoach.ui.detail.ItemDetailActivity
import hu.aut.bme.matesebi.todocoach.ui.detail.ItemDetailFragment
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [ItemDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class ItemListActivity : AppCompatActivity(), ListScreen, TaskListAdapter.Listener {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var twoPane: Boolean = false

    @Inject
    lateinit var presenter: ListPresenter

    @Inject
    lateinit var detailPresenter: DetailPresenter

    private lateinit var taskListAdapter: TaskListAdapter
    private lateinit var scope: CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        setSupportActionBar(toolbar)
        toolbar.title = title

        injector.inject(this)
        presenter.attachScreen(this)
        taskListAdapter = TaskListAdapter(this)
        item_list.adapter = taskListAdapter

        fab.setOnClickListener { v -> fabOnClickListener(v) }

        if (item_detail_container != null) {
            twoPane = true
        }
        scope = MainScope()
    }

    private fun fabOnClickListener(view: View) {
        with(AlertDialog.Builder(view.context)) {
            setTitle("Add a new Task")
            val layout = layoutInflater.inflate(R.layout.add_task_dialog, null)
            val addTaskContentET = layout.findViewById<EditText>(R.id.addTaskContentET)
            val addTaskPriorityRating = layout.findViewById<RatingBar>(R.id.addTaskPriorityRating)
            setView(layout)
            setNegativeButton("Cancel", null)
            setPositiveButton("Create") { _, _ ->
                scope.launch {
                    presenter.createTask(
                        addTaskContentET.text.toString(),
                        addTaskPriorityRating.rating.toInt(),
                        "2020-05-14"
                    )
                }
            }
            show()
        }
    }

    override fun onStart() {
        super.onStart()
        scope.launch {
            presenter.refreshList()
        }
    }

    override fun onResume() {
        super.onResume()
//        val uri = intent.data
//        uri?.also {
//            uri.getQueryParameter("code")?.also {
//                Toast.makeText(this, "code: $it", Toast.LENGTH_LONG).show()
//                authInterceptor.getToken(uri.getQueryParameter("code"))
//                Log.d("asdasd", "code: $it")
//            }
//            uri.getQueryParameter("access_token")?.also {
//                Toast.makeText(this, "access_token: $it", Toast.LENGTH_LONG).show()
//                authInterceptor.token = it
//                Log.d("asdasd", "access_token: $it")
//            }
//        }
    }

    override fun showItems(items: List<Task>) {
        runOnUiThread {
//            Snackbar.make(item_list, "Showing new items", Snackbar.LENGTH_LONG).show()
            taskListAdapter.submitList(items)
        }
    }

    override fun onTaskClicked(task: Task) {
        if (twoPane) {
            val fragment = ItemDetailFragment(detailPresenter).apply {
                arguments = Bundle().apply {
                    putString(ItemDetailFragment.ARG_ITEM_ID, task.id.toString())
                }
            }
            this.supportFragmentManager
                .beginTransaction()
                .replace(R.id.item_detail_container, fragment)
                .commit()
        } else {
            val intent = Intent(this, ItemDetailActivity::class.java).apply {
                putExtra(ItemDetailFragment.ARG_ITEM_ID, task.id.toString())
            }
            startActivity(intent)
        }
    }

    override fun onTaskCompleted(task: Task) {
        scope.launch {
            presenter.completeTask(task)
        }
    }
}
