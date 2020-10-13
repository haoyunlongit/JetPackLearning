package com.example.jetpack

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class MainActivity : AppCompatActivity() {

    @BindView(R.id.clickView) @JvmField var clickView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        clickView?.setBackgroundColor(Color.RED)
        clickView?.setOnClickListener {
        }
    }

}
