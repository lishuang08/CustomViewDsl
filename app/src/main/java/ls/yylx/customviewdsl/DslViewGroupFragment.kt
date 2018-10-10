package ls.yylx.customviewdsl

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import kotlin.system.measureNanoTime

class DslViewGroupFragment : Fragment() {
    val vm by lazy {
        ViewModelProviders.of(requireActivity())[MainViewModel::class.java]
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View? = null
        val time = measureNanoTime {
            view = inflater.inflate(R.layout.fragment_recycleview, container, false)
        }

        println("DslViewGroupFragment     $time ms")

        return view    }
}
