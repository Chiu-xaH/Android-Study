package com.hfut.retrofituse

import retrofit2.Retrofit

object RetrofitUtil {
    const val URL = "http://"

    val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    fun <T> create(service: Class<T>):T = retrofit.create(service)
}