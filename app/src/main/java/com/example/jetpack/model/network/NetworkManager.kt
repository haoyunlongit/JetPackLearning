package com.example.jetpack.model.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {
    fun <T> getServiceApi(clazz: Class<T>, baseUri: String): T {
        var retrofit2 = createRetrofix(OkHttpClient.Builder().build(),
            baseUri
        )
        return retrofit2.create(clazz)
    }

    private fun createRetrofix(client: OkHttpClient, baseUri: String): Retrofit {
        return Retrofit.Builder().client(client).baseUrl(baseUri).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
    }
}