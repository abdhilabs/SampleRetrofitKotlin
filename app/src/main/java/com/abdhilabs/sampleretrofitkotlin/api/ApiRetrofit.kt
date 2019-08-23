package com.abdhilabs.sampleretrofitkotlin.api

import com.google.gson.GsonBuilder
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import retrofit.GsonConverterFactory

object ApiRetrofit {

    val gson = GsonBuilder().create()

    fun create(): ApiService {
        val retrofit: Retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.github.com/")
                .build()
        return retrofit.create(ApiService::class.java)
    }
}