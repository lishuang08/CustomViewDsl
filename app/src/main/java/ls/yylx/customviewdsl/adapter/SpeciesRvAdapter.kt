package ls.yylx.customviewdsl.adapter

import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import kotlinx.coroutines.runBlocking
import ls.yylx.customviewdsl.R
import ls.yylx.customviewdsl.data.SpecieBox
import kotlin.system.measureTimeMillis


class SpeciesRvAdapter(list: List<SpecieBox>) :

        BaseQuickAdapter<SpecieBox, BaseViewHolder>(R.layout.item_specie, list) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        var base: BaseViewHolder? = null

        val time = measureTimeMillis {
            runBlocking {
                repeat(500) {
                    base = super.onCreateViewHolder(parent, viewType)
                }
            }
        }
        println("BaseViewHolder    $time  ms")

        return base!!
    }

    override fun convert(helper: BaseViewHolder, item: SpecieBox) {
        helper.setText(R.id.tv_name, item.toString())

    }

}