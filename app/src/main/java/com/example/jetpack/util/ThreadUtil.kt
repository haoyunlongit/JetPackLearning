package com.example.jetpack.util

import android.os.Looper

class ThreadUtil {
    companion object {
        fun isMainThread(): Boolean {
           return Thread.currentThread() == Looper.getMainLooper().thread
        }
    }
}