package com.hfut.cookiedemo

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.CookieHandler
import java.net.CookieManager
import java.net.CookiePolicy

class MainActivity : ComponentActivity() {
    val vm by lazy{ ViewModelProvider(this).get(MyViewModel::class.java)}
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        if (Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }


 //val request = Request.Builder()
         //   .url("https://cas.hfut.edu.cn/cas/login?service=http%3A%2F%2Fjxglstu.hfut.edu.cn%2Feams5-student%2Fneusoft-sso%2Flogin/")
          //  .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36 Edg/118.0.2088.17")
         //   .build()
       // val response = Client.newCall(request).execute()
       // response.body?.close()
            vm.get()

                }
            }
