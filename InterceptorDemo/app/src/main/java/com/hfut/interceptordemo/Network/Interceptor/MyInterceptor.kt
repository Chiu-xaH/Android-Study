package com.hfut.interceptordemo.Network.Interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        Log.d("请求头",request.headers.toString())
        val response = chain.proceed(request)
        Log.d("响应头",response.headers.toString())
        return response
    }
}

