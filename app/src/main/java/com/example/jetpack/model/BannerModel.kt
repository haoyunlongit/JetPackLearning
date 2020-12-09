package  com.example.jetpack.model

import android.util.Log
import com.example.jetpack.contract.BannerContract
import com.example.jetpack.model.network.NetWorkCommentInterface
import com.example.jetpack.model.network.NetworkBaseManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import mvp.ljb.kt.model.BaseModel
import java.lang.Exception

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/10/14
 * @Description input description
 **/
class BannerModel : BaseModel(), BannerContract.IModel {
    override fun requestBannerDate() {
        var tempInter: NetWorkCommentInterface = NetworkBaseManager.getServiceApi(
            NetWorkCommentInterface::class.java,
            "https://gank.io/"
        )
        try {
            tempInter.getBannerInfo().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribeBy(onError = {
                    Log.e("hyl", "messge$it", it)
                },
                onSuccess = {
                    it.raw().toString()
                    Log.i("hyl", "messge")
                })
        } catch (ex: Exception) {
            Log.e("hyl", "eeeor" ,ex)
        }
    }
}