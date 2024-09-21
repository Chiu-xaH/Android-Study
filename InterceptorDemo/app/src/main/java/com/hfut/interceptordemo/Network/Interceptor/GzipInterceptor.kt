package com.hfut.interceptordemo.Network.Interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.Response
import okio.BufferedSink
import okio.GzipSink
import okio.Okio
import okio.buffer

class GzipInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        return chain.proceed(originalRequest)
        val compressedResult = originalRequest.newBuilder()
            .header("Content-Encoding","gzp")
            .method(originalRequest.method, originalRequest.body?.let { gzip(it) })
            .build()
       // Log.d("Gzip", originalRequest.body?.let { gzip(it) }.toString())
       // Log.d("Gzip",gzipSink.toString())
        return chain.proceed(compressedResult)
    }

    private fun gzip(body : RequestBody) : RequestBody {
        return object : RequestBody() {
            override fun contentType(): MediaType? {
                return body.contentType()
            }

            override fun contentLength(): Long {
                return -1//我们事先不知道压缩长度!
            }

            override fun writeTo(sink: BufferedSink) {
                val gzipSink = GzipSink(sink).buffer()
                body.writeTo(gzipSink)

                //Log.d("Gzip",body.toString())
                gzipSink.close()
            }
        }
    }
}