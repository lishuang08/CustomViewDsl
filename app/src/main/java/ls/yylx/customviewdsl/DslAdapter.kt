package ls.yylx.customviewdsl

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.runBlocking
import ls.yylx.customviewdsl.custom.customItemFile
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.custom.customView
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

class DslAdapter(val items: List<SpecieBox>) : RecyclerView.Adapter<SpecieBoxViewHolder>() {

    override fun getItemCount(): Int = items.size

//    var items: List<SpecieBox> by Delegates.observable(list) { _, old, new ->
//        autoNotify(old, new) { o, n -> o.nameKey == n.nameKey }
//    }

    var ischeck = false

    var back: ((item: SpecieBox) -> Unit)? = null


    fun setOnItemClickListener(item: (item: SpecieBox) -> Unit) {
        back = item
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecieBoxViewHolder {
        var ho: SpecieBoxViewHolder? = null

        val viewHolder by lazy {
            ItemViewHolder()
        }

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
            customItemFile(viewHolder)


        }
}
