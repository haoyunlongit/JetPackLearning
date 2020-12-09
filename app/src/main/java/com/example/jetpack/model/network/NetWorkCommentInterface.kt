package com.example.jetpack.model.network

import io.reactivex.Single
import okhttp3.Call
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface NetWorkCommentInterface {
    //首页banner轮播
    @GET("api/v2/banners")
    fun getBannerInfo(): Single<Response<JSONObject>>
}