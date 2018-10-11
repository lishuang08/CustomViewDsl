package ls.yylx.customviewdsl.custom

import android.view.ViewManager
import android.widget.LinearLayout
import ls.yylx.customviewdsl.data.ItemViewHolder
import ls.yylx.customviewdsl.R
import org.jetbrains.anko.*


fun ViewManager.customItemExt(holder: ItemViewHolder) = linearLayout {
    lparams(matchParent)
    orientation = LinearLayout.HORIZONTAL
    imageView {
        imageResource = R.mipmap.ic_launcher
    }.lparams(width = dip(56), height = dip(56))
    holder.tv0 = textView {
        id = R.id.tv_name
        text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    }.lparams(width = 0, height = dip(56)) {
        weight = 1f
    }
    holder.tv1 = textView {
        id = R.id.tv_tag
        text = "tag"
    }.lparams(width = dip(56), height = dip(56))
}
