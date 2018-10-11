package ls.yylx.customviewdsl.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ls.yylx.customviewdsl.custom.DslCustomItemGroup
import ls.yylx.customviewdsl.custom.customItemExt
import ls.yylx.customviewdsl.data.ItemViewHolder
import ls.yylx.customviewdsl.testTime
import org.jetbrains.anko.custom.customView
import org.jetbrains.anko.scrollView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.textView
import kotlin.system.measureTimeMillis


class DslExt_DslFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        return UI {scrollView {
            tv = textView { }
        } }.view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testTime(4)
    }

}
