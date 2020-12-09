package com.example.jetpack

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import butterknife.BindView
import com.example.jetpack.base.view.BaseActivity

class MainActivity : BaseActivity() {
    @BindView(R.id.GotoRxJava) @JvmField var gotoRxJava: TextView? = null

    @BindView(R.id.GotoLearningRetrofix) @JvmField var gotoRetrofit: TextView? = null

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gotoRxJava?.setOnClickListener {
            Intent(this, RxJavaActivity::class.java).run {
                startActivity(this)
            }
        }

        gotoRetrofit?.setOnClickListener {

        }
    }

    override fun layoutResource(): Int {
        return R.layout.activity_main
    }


}
