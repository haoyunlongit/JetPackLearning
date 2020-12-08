package com.example.jetpack

import android.util.Log

object TestClass {
    lateinit var name: String
    fun init() {
    }

    fun testMyTemp() {
        Log.i("hyl", "name + $name")
    }
}