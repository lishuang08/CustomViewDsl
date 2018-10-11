package ls.yylx.customviewdsl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import io.objectbox.Box
import io.objectbox.kotlin.boxFor
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    val navController by lazy {
        findNavController(R.id.main_fragment)
    }


    val vm by lazy {
        ViewModelProviders.of(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NavigationUI.setupActionBarWithNavController(this,navController)

//        bottom_bar.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.xmlFragment -> {
//                    navController.navigate(R.id.action_global_xmlFragment)
//
//                }
//                R.id.dslFragment -> {
//                    navController.navigate(R.id.action_global_dslFragment)
//                }
//                R.id.xmlCustomViewFragment -> {
//                    navController.navigate(R.id.action_global_xmlCustomViewFragment)
//
//                }
//                R.id.dslCodeFragment -> {
//                    navController.navigate(R.id.dslCodeFragment)
//
//                }
//                R.id.dslGroupXmlFragment -> {
//                    navController.navigate(R.id.action_global_dslGroupXmlFragment)
//                }
//
//            }
//            true
//        }
    }

    override fun onSupportNavigateUp() = navController.navigateUp()


    override fun onResume() {
        super.onResume()
        vm.getData()
    }



}