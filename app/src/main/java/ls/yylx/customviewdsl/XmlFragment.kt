package ls.yylx.customviewdsl


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.runBlocking
import org.jetbrains.anko.find
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis


class XmlFragment : Fragment() {
    val vm by lazy {
        ViewModelProviders.of(requireActivity())[MainViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View? = null
        val time = measureTimeMillis {
//            runBlocking {
                view = inflater.inflate(R.layout.fragment_recycleview, container, false)

//                repeat(10000) {
//                    println(it)
                    view!!.find<RecyclerView>(R.id.rv).run {
                        adapter = SpeciesRvAdapter(vm.all)
                        layoutManager = LinearLayoutManager(requireContext())
                    }
//                }
//            }
        }

        println("XmlFragment     $time ms")

        return view
    }


}
