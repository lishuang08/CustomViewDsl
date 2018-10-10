package ls.yylx.customviewdsl

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis


class DslCustomFragment : Fragment() {
    val vm by lazy {
        ViewModelProviders.of(requireActivity())[MainViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view: View? = null
        val time = measureTimeMillis {
            view = UI { recyclerView() }.view
        }

        println("DslCustomFragment     $time ms")

        return view
    }



}
