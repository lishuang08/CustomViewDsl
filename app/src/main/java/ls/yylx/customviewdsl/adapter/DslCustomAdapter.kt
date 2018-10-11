package ls.yylx.customviewdsl.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_custom.view.*
import kotlinx.coroutines.runBlocking
import ls.yylx.customviewdsl.R
import ls.yylx.customviewdsl.custom.CustomItemView
import ls.yylx.customviewdsl.data.ItemViewHolder
import ls.yylx.customviewdsl.data.SpecieBox
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.custom.customView
import org.jetbrains.anko.dip
import org.jetbrains.anko.find
import kotlin.system.measureTimeMillis

class DslCustomAdapter(val items: List<SpecieBox>) : RecyclerView.Adapter<SpecieBoxCustomViewHolder>() {


    override fun getItemCount(): Int = items.size

//    var items: List<SpecieBox> by Delegates.observable(list) { _, old, new ->
//        autoNotify(old, new) { o, n -> o.nameKey == n.nameKey }
//    }

    var ischeck = false

    var back: ((item: SpecieBox) -> Unit)? = null


    fun setOnItemClickListener(item: (item: SpecieBox) -> Unit) {
        back = item
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecieBoxCustomViewHolder {
        var ho: SpecieBoxCustomViewHolder? = null

        val viewHolder by lazy {
            ItemViewHolder()
        }

        val time = measureTimeMillis {
            runBlocking {
                repeat(500) {
                    ho = SpecieBoxCustomViewHolder(parent)
                }
            }
        }
        println("SpecieBoxViewHolder    $time  ms")

        return ho!!
    }


    override fun onBindViewHolder(holder: SpecieBoxCustomViewHolder, position: Int) {
        holder.bindTo(items[position])

        holder.itemView.setOnClickListener {
            if (back != null) back!!(items[position])
        }
    }

}


class SpecieBoxCustomViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        DslCustomAdapterview().createView(AnkoContext.create(parent.context, parent))) {

    fun bindTo(item: SpecieBox) {
        itemView.find<CustomItemView>(R.id.item).textName = item.toString()
    }
}


class DslCustomAdapterview() : AnkoComponent<View> {

    override fun createView(ui: AnkoContext<View>) =
        with(ui) {
            customView<CustomItemView> {
                layoutParams = FrameLayout.LayoutParams(-2, dip(56))
                id   = R.id.item
            }
        }
}
