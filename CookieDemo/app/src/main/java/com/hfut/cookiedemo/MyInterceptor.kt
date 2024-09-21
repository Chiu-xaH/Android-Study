package com.hfut.cookiedemo

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()


        val s = chain.proceed(originalRequest)
        Log.d("测试tttw", originalRequest.headers.toString())
        Log.d("测试ttt", originalRequest.toString())
        //val compressRequest = originalRequest.newBuilder()
           // .header("Content-Encoding","gzip")
            //.build()
      //  return chain.proceed(compressRequest)
        return s
    }
}