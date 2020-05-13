package hu.aut.bme.matesebi.todocoach.ui.detail

import android.content.Intent
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.Display
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import hu.aut.bme.matesebi.todocoach.R
import hu.aut.bme.matesebi.todocoach.injector
import hu.aut.bme.matesebi.todocoach.model.DummyContent
import hu.aut.bme.matesebi.todocoach.model.Task
import hu.aut.bme.matesebi.todocoach.ui.list.ItemListActivity
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.item_detail.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.absoluteValue

/**
 * An activity representing a single Item detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [ItemListActivity].
 */
class ItemDetailActivity : AppCompatActivity(), DetailScreen {

    @Inject
    lateinit var detailPresenter: DetailPresenter

    lateinit var fragment: ItemDetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(detail_toolbar)

        injector.inject(this)
        detailPresenter.attachScreen(this)
        fab.setOnClickListener { view ->

            MainScope().launch {
                if (fragment.task == null) {
//                    Snackbar.make(view, "No task", Snackbar.LENGTH_LONG).show()
                }

                fragment.task?.let {
//                    Snackbar.make(view, "Complete", Snackbar.LENGTH_LONG).show()
                    detailPresenter.completeTask(it)
                }
            }
        }

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            fragment = ItemDetailFragment(detailPresenter).apply {
                arguments = Bundle().apply {
                    putString(
                        ItemDetailFragment.ARG_ITEM_ID,
                            intent.getStringExtra(ItemDetailFragment.ARG_ITEM_ID))
                }
            }

            supportFragmentManager.beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
            when (item.itemId) {
                android.R.id.home -> {
                    // This ID represents the Home or Up button. In the case of this
                    // activity, the Up button is shown. For
                    // more details, see the Navigation pattern on Android Design:
                    //
                    // http://developer.android.com/design/patterns/navigation.html#up-vs-back

                    navigateUpTo(Intent(this, ItemListActivity::class.java))
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }

    override fun showDetails(task: Task) {
        fragment.task = task
        runOnUiThread {
            taskDetailContentTV.text = task.content
            taskDetailDueTV.text = task.due?.string
            val colorId = when(task.priority) {
                1 -> R.color.priorityLow
                2 -> R.color.priorityNormal
                3 -> R.color.priorityMedium
                else -> R.color.priorityHigh
            }
            val color = resources.getColor(colorId, theme)
            taskDetailPriorityIV.drawable.setTint(color)
        }
    }

    override fun navigateBack() {
        navigateUpTo(Intent(this, ItemListActivity::class.java))
    }
}
