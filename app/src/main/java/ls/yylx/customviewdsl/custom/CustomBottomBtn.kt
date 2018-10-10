package ls.yylx.customviewdsl.custom

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.CheckBox
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout

class CustomItemGroup : FrameLayout {


    constructor(context: Context) : super(context) {

        initUi(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initUi(context)
    }


    lateinit var ivFile: ImageView
    lateinit var ivFunction: ImageView

    lateinit var tvName: TextView
    lateinit var tvTime: TextView
    lateinit var tvSize: TextView
    lateinit var tvCreator: TextView
    lateinit var tvComment: TextView

    lateinit var cbChecked: CheckBox


    inline fun initUi(ctx: Context) {

        addView(ctx.UI {

            constraintLayout {
                lparams(matchParent, matchParent)

                cbChecked = checkBox {
                    id = cbIdChecked
                    isClickable = false
                    isFocusable = false
                    visibility = View.GONE
                }.lparams(width = dip(30), height = dip(30)) {
                    topMargin = dip(8)
                    bottomMargin = dip(8)
                    marginStart = dip(16)
                    bottomToBottom = ConstraintSet.PARENT_ID
                    topToTop = ConstraintSet.PARENT_ID
                    startToStart = ConstraintSet.PARENT_ID
                }
                ivFile = imageView {
                    id = ivIdFile
                    scaleType = ImageView.ScaleType.CENTER_CROP
                }.lparams(width = dip(48), height = dip(48)) {
                    marginStart = dip(16)
                    topMargin = dip(8)
                    bottomMargin = dip(8)

                    bottomToBottom = ConstraintSet.PARENT_ID
                    topToTop = ConstraintSet.PARENT_ID
                    startToEnd = cbIdChecked

                }
                tvName = textView {
                    id = tvIdName
                    ellipsize = TextUtils.TruncateAt.END
                    maxLines = 1
                    text = "111111111"
                    textSize = 16f
                }.lparams(width = 0) {
                    marginStart = dip(16)
                    topMargin = dip(8)
                    marginEnd = dip(8)

                    bottomToTop = tvIdCreator
                    topToTop = ConstraintSet.PARENT_ID
                    startToEnd = ivIdFile
                    endToStart = ivIdFunction

                }
                tvCreator = textView {
                    id = tvIdCreator
                    maxEms = 5
                    ellipsize = TextUtils.TruncateAt.END
                    maxLines = 1
                    text = "New Text"
                    textSize = 12f //sp
                }.lparams(height = dip(14)) {
                    marginStart = dip(16)
                    bottomMargin = dip(8)

                    horizontalChainStyle = ConstraintSet.CHAIN_PACKED
                    horizontalBias = 0F

                    bottomToBottom = ConstraintSet.PARENT_ID
                    topToBottom = tvIdName
                    startToEnd = ivIdFile
                    endToStart = tvIdSize

                }
                tvSize = textView {
                    id = tvIdSize
                    maxLines = 1
                    text = "2222"
                    textSize = 12f //sp
                    visibility = View.VISIBLE
                }.lparams {
                    marginStart = dip(8)



                    topToTop = tvIdCreator
                    startToEnd = tvIdCreator
                    endToStart = tvIdTime

                }
                tvTime = textView {
                    id = tvIdTime
                    maxLines = 1
                    text = "1111111"
                    textSize = 12f //sp
                }.lparams {

                    topToTop = tvIdCreator

                    startToEnd = tvIdSize
                    endToStart = tvIdComment

                    marginStart = dip(8)
                }
                tvComment = textView {
                    id = tvIdComment
                    maxLines = 1
                    text = "TextView"
                    textSize = 12f //sp
                    visibility = View.VISIBLE
                }.lparams {
                    topToTop = tvIdCreator

                    startToEnd = tvIdTime
                    endToStart = ivIdFunction


                    marginStart = dip(8)
                }


                ivFunction = imageView {
                    id = ivIdFunction
                    background = null
                    isFocusable = false
                    scaleType = ImageView.ScaleType.CENTER_INSIDE
                }.lparams(width = dip(48), height = dip(56)) {
                    bottomToBottom = ConstraintSet.PARENT_ID
                    topToTop = ConstraintSet.PARENT_ID
                    endToEnd = ConstraintSet.PARENT_ID

                }


            }
        }.view)
    }
}