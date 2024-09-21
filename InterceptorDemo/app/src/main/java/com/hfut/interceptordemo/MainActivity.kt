package com.hfut.interceptordemo

import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hfut.interceptordemo.Network.Interceptor.GzipInterceptor
import com.hfut.interceptordemo.Network.Interceptor.MyInterceptor
import com.hfut.interceptordemo.ui.theme.InterceptorDemoTheme
import okhttp3.Cookie
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.cookieToString

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        val client = OkHttpClient.Builder()
            .addNetworkInterceptor(MyInterceptor())
            .addInterceptor(GzipInterceptor())
            .build()

        val request = Request.Builder()
            .url("https://xz.chsi.com.cn/home.action/")
            .header("Cookie", cookieToString())
            .build()

        val response = client.newCall(request).execute()
        Log.d("主程序",request.headers.toString())
        response.body?.close()
    }
}

