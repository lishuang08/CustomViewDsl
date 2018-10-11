package ls.yylx.customviewdsl.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.runBlocking
import ls.yylx.customviewdsl.custom.customItemExt
import ls.yylx.customviewdsl.data.ItemViewHolder
import ls.yylx.customviewdsl.data.SpecieBox
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import kotlin.properties.Delegates
import kotlin.system.measureTimeMillis

class DslAdapter(val list : List<SpecieBox>) : RecyclerView.Adapter<SpecieBoxViewHolder>() {
    var items: List<SpecieBox> by Delegates.observable(list) { _, old, new ->
        autoNotify(old, new) { o, n -> o.nameKey == n.nameKey }
    }
    var back: ((item: SpecieBox) -> Unit)? = null
    fun setOnItemClickListener(item: (item: SpecieBox) -> Unit) {
        back = item
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecieBoxViewHolder {
        var ho: SpecieBoxViewHolder? = null
        val viewHolder = ItemViewHolder()
        val time = measureTimeMillis {
            runBlocking {
                repeat(500) {
                    ho = SpecieBoxViewHolder(parent, viewHolder)
                }
            }
        }
        println("SpecieBoxViewHolder    $time  ms")

        return ho!!
    }

    override fun onBindViewHolder(holder: SpecieBoxViewHolder, position: Int) {
        holder.bindTo(items[position])

        holder.itemView.setOnClickListener {
            if (back != null) back!!(items[position])
        }
    }

}


class SpecieBoxViewHolder(parent: ViewGroup, val viewHolder: ItemViewHolder) : RecyclerView.ViewHolder(
        DslAdapterview(viewHolder).createView(AnkoContext.create(parent.context, parent))) {
    fun bindTo(item: SpecieBox) {
        viewHolder.tv0?.text = item.toString()
    }
}


class DslAdapterview(val viewHolder: ItemViewHolder) : AnkoComponent<View> {
    override fun createView(ui: AnkoContext<View>) =
        with(ui) {
            customItemExt(viewHolder)
        }
}
