package com.example.jetpack.model.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkBaseManager {
    fun <T> getServiceApi(clazz: Class<T>, baseUri: String): T {
        var retrofit2 = createRetrofit(OkHttpClient.Builder().build(),
            baseUri
        )
        return retrofit2.create(clazz)
    }

    private fun createRetrofit(client: OkHttpClient, baseUri: String): Retrofit {
        return Retrofit.Builder().client(client).baseUrl(baseUri).
        addConverterFactory(GsonConverterFactory.create()
        ).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}