package com.hfut.retrofituse

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/")
    suspend fun test() : String

    @FormUrlEncoded
    @POST
    suspend fun queryByName(@Field("filename") name:String):String
}