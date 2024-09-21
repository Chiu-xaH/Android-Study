package com.hfut.cookiedemo

import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.CookieJar
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy

object ServiceCreator {
    val URL =  "https://cas.hfut.edu.cn/"


    val Client = OkHttpClient.Builder()
        .cookieJar(PersistenceCookieJar())
        .addNetworkInterceptor(AESKeyInterceptor())
       // .addInterceptor(LoggingInterceptor())
        .build()






    val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .client(Client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()



    fun <T> create(service: Class<T>): T = retrofit.create(service)



}