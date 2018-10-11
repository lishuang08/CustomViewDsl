package ls.yylx.customviewdsl

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.objectbox.kotlin.boxFor
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ls.yylx.customviewdsl.data.MyObjectBox
import ls.yylx.customviewdsl.data.SpecieBox
import ls.yylx.customviewdsl.network.ApiGbif
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

class MainViewModel(app: Application) : AndroidViewModel(app) {

    val boxStore by lazy {
        MyObjectBox.builder().androidContext(getApplication()).build().boxFor<SpecieBox>()
    }

    val BaseUrlGbif = "http://api.gbif.org/v1/"


    val retrofitGbif by lazy {
        Retrofit.Builder()
                .client(getOkhttpBuilder())
                .baseUrl(BaseUrlGbif)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiGbif::class.java)
    }

    fun getOkhttpBuilder(): OkHttpClient {
        // 创建OkHttpClient
        val builder = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .retryOnConnectionFailure(false)  // 错误重连
                // 支持HTTPS
                .connectionSpecs(Arrays.asList(ConnectionSpec.CLEARTEXT, ConnectionSpec.MODERN_TLS)) //明文Http与比较新的Https
        // cookie管理
        // .cookieJar(PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(this)))
        // 添加各种插入器
        return builder.build()
    }


    fun getData() {
        if (boxStore.count() < 900) GlobalScope.launch {
            val back = retrofitGbif.getSpeciesBox(0, 1000).execute()
            if (back.isSuccessful) {
                val backList = back.body()?.results ?: emptyList()
                if (backList.isNotEmpty()) {
                    boxStore.apply {
                        put(backList)
                    }
                }
            }
        }
    }


    val all by lazy {
        boxStore.all
    }

}
