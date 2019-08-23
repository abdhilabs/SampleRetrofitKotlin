package com.abdhilabs.sampleretrofitkotlin.api

import com.abdhilabs.sampleretrofitkotlin.entity.Github
import retrofit.http.GET
import retrofit.http.Path
import rx.Observable

interface ApiService {

    @GET("users/{username}")
    fun getUSer(@Path("username") username: String): Observable<Github>
}