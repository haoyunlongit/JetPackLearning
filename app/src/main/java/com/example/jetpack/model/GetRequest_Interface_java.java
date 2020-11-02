package com.example.jetpack.model;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface GetRequest_Interface_java {
    @GET("https://gank.io/api/v2/banners")
    public Call<Translation> getCall();

}
