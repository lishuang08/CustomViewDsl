package ls.yylx.customviewdsl.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import ls.yylx.customviewdsl.R
import org.jetbrains.anko.*

class DslCustomItemGroup : FrameLayout {


    constructor(context: Context) : super(context) {
        initUi(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initUi(context)
    }



     var tvName: TextView?=null


    inline fun initUi(ctx: Context) {

        addView(ctx.UI {
            linearLayout {
                lparams(matchParent)
                orientation = LinearLayout.HORIZONTAL
                imageView {
                    imageResource = R.mipmap.ic_launcher
                }.lparams(width = dip(56), height = dip(56))
                tvName = textView {
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

        }.view)
    }
}