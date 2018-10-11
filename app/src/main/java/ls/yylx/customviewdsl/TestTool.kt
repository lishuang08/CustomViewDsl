package ls.yylx.customviewdsl

import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ls.yylx.customviewdsl.custom.CustomItemView
import ls.yylx.customviewdsl.custom.DslCustomItemGroup
import ls.yylx.customviewdsl.custom.customItemExt
import ls.yylx.customviewdsl.data.ItemViewHolder
import ls.yylx.customviewdsl.fragment.BaseFragment
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.customView
import org.jetbrains.anko.support.v4.UI
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

inline fun BaseFragment.testTime(type: Int) {
    var v: View? = null
    val inflater = LayoutInflater.from(requireContext())
    val holder = ItemViewHolder()
    var t = 0L


    GlobalScope.launch {
        repeat(50) {
            val time = measureTimeMillis {
                runBlocking {
                    repeat(1000) {
                        v = when (type) {
                            6 -> UI { customView<CustomItemView> {} }.view
                            5 -> inflater.inflate(R.layout.item_custom, null)
                            4 -> UI { customItemExt(holder) }.view
                            3 -> UI { customView<DslCustomItemGroup> { } }.view
                            2 -> inflater.inflate(R.layout.item_custom_group, null)
                            1 -> UI {
                                linearLayout {
                                    lparams(matchParent)
                                    orientation = LinearLayout.HORIZONTAL
                                    imageView {
                                        imageResource = R.mipmap.ic_launcher
                                    }.lparams(width = dip(56), height = dip(56))
                                    textView {
                                        id = R.id.tv_name
                                        text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                                    }.lparams(width = 0, height = dip(56)) {
                                        weight = 1f
                                    }
                                    textView {
                                        id = R.id.tv_tag
                                        text = "tag"
                                    }.lparams(width = dip(56), height = dip(56))
                                }
                            }.view
                            0 -> inflater.inflate(R.layout.item_specie, null)


                            else -> null
                        }

                    }
                }
            }
            launch(Dispatchers.Main) {
                tv.text = """${tv.text}
                    |$it 时间:$time ms""".trimMargin()

                t += time
            }
        }


        launch(Dispatchers.Main) {
            tv.text = """${when (type) {
                6 -> "自定义View  Dsl加载"
                5 -> "自定义view  xml加载"
                4 -> "dsl扩展   dsl加载"
                3 -> "dsl自定义Group   dsl加载"
                2 -> "dsl自定义Group   xml加载"
                1 -> "纯dsl 加载"
                0 -> "纯xml 加载 "
                else -> null
            }} 平均时间:   ${t / 50}ms
            |${tv.text}""".trimMargin()


        }

    }
}