package anko

import android.app.Activity
import android.os.Bundle
import android.graphics.*
import android.widget.*
import android.view.*
import org.jetbrains.anko.*

import ls.yylx.customviewdsl.R

/**
 * Generate with Plugin
 * @plugin Kotlin Anko Converter For Xml
 * @version 1.3.4
 */
class ItemSpecieActivity : Activity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		linearLayout {
			orientation = LinearLayout.HORIZONTAL
			imageView {
				imageResource = R.mipmap.ic_launcher
			}.lparams(width = dip(56), height = dip(56))
			textView {
				id = R.id.tv_name
			}.lparams(width = matchParent, height = dip(56))
			textView {
				id = R.id.tv_tag
				text = "tag"
			}.lparams(width = dip(56), height = dip(56))
		}
	}
}
