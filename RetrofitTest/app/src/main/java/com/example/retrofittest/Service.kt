package com.example.retrofittest

import retrofit2.Call
import retrofit2.http.GET

interface Service {
    @GET("b.json")
    fun get() : Call<List<App>>
}