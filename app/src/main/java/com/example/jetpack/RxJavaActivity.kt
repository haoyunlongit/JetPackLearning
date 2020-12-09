package com.example.jetpack

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import butterknife.BindView
import com.example.jetpack.base.view.BaseActivity
import com.example.jetpack.util.ThreadUtil
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RxJavaActivity : BaseActivity(), View.OnClickListener {
    @BindView(R.id.textView)
    @JvmField
    var clickView: TextView? = null
    var TAG = "RxJavaActiviy"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("hyl", "onCreate")
        clickView?.setOnClickListener(this)
    }

    override fun layoutResource(): Int {
        return R.layout.activity_rxjava_layout
    }

    override fun onClick(v: View?) {
        Log.i("hyl", "click")
        Observable.create(ObservableOnSubscribe<String?> { emitter ->
            emitter.onNext("连载1")
            emitter.onNext("连载2")
            emitter.onNext("连载3")
            emitter.onComplete()
        })
            .observeOn(AndroidSchedulers.mainThread()) //回调在主线程
            .subscribeOn(Schedulers.io()) //执行在io线程
            .subscribe(object : Observer<String?> {
                override fun onSubscribe(d: Disposable) {
                    Log.i(TAG, "onSubscribe is thread" + ThreadUtil.isMainThread())
                }

                override fun onNext(t: String) {
                    Log.i(TAG, "onNext is thread" + ThreadUtil.isMainThread())
                }

                override fun onError(e: Throwable) {
                    Log.i(TAG, "onError is thread" + ThreadUtil.isMainThread())
                }

                override fun onComplete() {
                    Log.i(TAG, "onComplete is thread" + ThreadUtil.isMainThread())
                }

            })

    }
}