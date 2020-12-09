package com.example.jetpack.base.view

import android.app.Fragment
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutInflater.inflate(layoutResource(), null, false)?.run {
            setContentView(this)
        }

        ButterKnife.bind(this)
        Log.i("hyl", "${javaClass.simpleName} onCreate")
    }

    abstract fun layoutResource(): Int

    override fun onStart() {
        super.onStart()
        Log.i("hyl", "${javaClass.simpleName} onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("hyl", "${javaClass.simpleName} onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("hyl", "${javaClass.simpleName} onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("hyl", "${javaClass.simpleName} onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("hyl", "${javaClass.simpleName} onDestroy")
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.i("hyl", "${javaClass.simpleName} onAttachedToWindow")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)
    }
}