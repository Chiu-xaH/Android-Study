package com.hfut.cookiedemo;

import android.preference.PreferenceManager
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class ReceivedCookiesInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
                // 获取响应对象
                val response = chain.proceed(chain.request())
                // 获取响应头中的Set-Cookie字段
                val cookies = response.headers("Set-Cookie")
                // 定义一个变量用于存储LOGIN_FLAVORING
                Log.d("TAGGGG",cookies.toString())

                return response
        }

}

