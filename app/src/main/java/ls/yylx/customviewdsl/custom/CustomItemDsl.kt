package ls.yylx.customviewdsl.custom

import android.view.ViewManager
import android.widget.LinearLayout
import ls.yylx.customviewdsl.ItemViewHolder
import ls.yylx.customviewdsl.R
import org.jetbrains.anko.*

val ivIdFile = 200000011
val ivIdFunction = 200000022

val tvIdName = 300000011
val tvIdTime = 300000022
val tvIdSize = 300000033
val tvIdCreator = 300000044
val tvIdComment = 300000055

val cbIdChecked = 400000011


fun ViewManager.customItemFile(holder: ItemViewHolder) = linearLayout {
        lparams(matchParent)
        orientation = LinearLayout.HORIZONTAL
        imageView {
            imageResource = R.mipmap.ic_launcher
        }.lparams(width = dip(56), height = dip(56))
        holder.tv0 = textView {
            id = R.id.tv_name
            text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        }.lparams(width = matchParent, height = dip(56))
        holder.tv1 = textView {
            id = R.id.tv_tag
            text = "tag"
        }.lparams(width = dip(56), height = dip(56))
    }
