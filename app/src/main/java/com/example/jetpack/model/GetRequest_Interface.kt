package com.example.jetpack.model

import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GetRequest_Interface {
    @GET("/api/v2/banners")
    fun getCall(): Call<BannerData>
}