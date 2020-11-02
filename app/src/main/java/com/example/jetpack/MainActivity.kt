package com.example.jetpack

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.example.jetpack.model.BannerData
import com.example.jetpack.model.GetRequest_Interface
import com.example.jetpack.model.network.NetworkManager
import com.example.jetpack.util.Constants
import okhttp3.Callback
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    @BindView(R.id.clickView) @JvmField var clickView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        clickView?.setBackgroundColor(Color.RED)
        clickView?.setOnClickListener {
            for (i in 0..10) {
            Thread(Runnable {
                var temp: GetRequest_Interface = NetworkManager.getServiceApi(
                    GetRequest_Interface::class.java,
                    Constants.BASE_URL
                )
                var tempCall = temp.getCall()
                val data = tempCall.execute()
                var body = data.body()
                Log.i("hyl","$i" + body.toString())
            }).run {
                start()
            }
        }
        }
    }

}
