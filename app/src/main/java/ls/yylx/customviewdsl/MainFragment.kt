package ls.yylx.customviewdsl


import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.button
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.UI

class MainFragment : Fragment() {
    val navController by lazy {
        findNavController()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return UI {
            linearLayout {
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER
                button {
                    text = "纯xml界面"
                    onClick { navController.navigate(R.id.action_mainFragment_to_xmlFragment) }
                }
                button {
                    text = "纯dsl界面"
                    onClick { navController.navigate(R.id.action_mainFragment_to_dslFragment) }
                }
                button {
                    text = "使用dsl自定义Group 的界面---xml加载"
                    onClick { navController.navigate(R.id.action_mainFragment_to_dslGroup_XmlFragment) }
                }
                button {
                    text = "使用dsl自定义Group 的界面---dsl加载"
                    onClick { navController.navigate(R.id.action_mainFragment_to_dslGroup_DslFragment) }
                }
                button {
                    text = "使用dsl扩展的group 的界面---dsl加载"
                    onClick { navController.navigate(R.id.action_mainFragment_to_dslExt_DslFragment) }
                }

                button {
                    text = "自定义view 的界面---xml加载"
                    onClick { navController.navigate(R.id.action_mainFragment_to_customView_XmlFragment) }
                }
                button {
                    text = "自定义view 的界面---dsl加载"
                    onClick { navController.navigate(R.id.action_mainFragment_to_customView_DslFragment) }
                }


            }
        }.view
    }


}
