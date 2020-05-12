package hu.aut.bme.matesebi.todocoach.ui.detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hu.aut.bme.matesebi.todocoach.R
import hu.aut.bme.matesebi.todocoach.model.Task
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.item_detail.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class ItemDetailFragment(private val detailPresenter: DetailPresenter) : Fragment() {

    var task: Task? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {

                val id = it.get(ARG_ITEM_ID).toString().toLong()
                MainScope().launch {
                    detailPresenter.getDetails(id)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_detail, container, false)
    }

    companion object {
        const val ARG_ITEM_ID = "item_id"
    }

}
