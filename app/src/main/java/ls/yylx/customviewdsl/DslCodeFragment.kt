package ls.yylx.customviewdsl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.runBlocking
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.view
import kotlin.system.measureTimeMillis


class DslCodeFragment : Fragment() {
    val vm by lazy {
        ViewModelProviders.of(requireActivity())[MainViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View? = null
        val time = measureTimeMillis {
            //            runBlocking {
            view = UI {
                recyclerView {
                    //                        repeat(10000) {
                    adapter = DslAdapter(vm.all)
                    layoutManager = LinearLayoutManager(requireContext())
                }
//                    }
            }.view

//            }
        }
        println("DslCodeFragment     $time ms")

        return view
    }


}
