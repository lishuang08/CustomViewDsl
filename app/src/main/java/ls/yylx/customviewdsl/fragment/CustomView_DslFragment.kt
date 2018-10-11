package ls.yylx.customviewdsl.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import ls.yylx.customviewdsl.MainViewModel
import ls.yylx.customviewdsl.custom.CustomItemView
import ls.yylx.customviewdsl.testTime
import org.jetbrains.anko.custom.customView
import org.jetbrains.anko.scrollView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.textView


class CustomView_DslFragment : BaseFragment() {
    val vm by lazy {
        ViewModelProviders.of(requireActivity())[MainViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        return UI {scrollView {
            tv = textView { }
        } }.view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testTime(6)
    }

}
