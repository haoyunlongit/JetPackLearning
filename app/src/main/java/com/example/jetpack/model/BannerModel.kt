package  com.example.jetpack.model

import com.example.jetpack.contract.BannerContract
import com.example.jetpack.model.network.NetworkManager
import mvp.ljb.kt.model.BaseModel
import mvp.ljb.kt.model.CallBack
import okhttp3.*
import java.io.IOException

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/10/14
 * @Description input description
 **/
class BannerModel : BaseModel(), BannerContract.IModel {
    val BASE_HTTP: String = "https://gank.io/api/v2/banners"

    override fun requestBannerDate() {
        var request = Request.Builder().url(BASE_HTTP).build()
        var client = OkHttpClient()
        var call = client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {

            }

        })
    }
}