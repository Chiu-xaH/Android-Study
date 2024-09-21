package com.hfut.requestdemo

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import okhttp3.OkHttpClient
import okhttp3.Request


class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        if (Build.VERSION.SDK_INT > 9) {
            val policy = ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }
        val b : Button = findViewById(R.id.b)
        b.setOnClickListener {

                val client = OkHttpClient()
                Log.d("失败","s2222ai")
                val request = Request.Builder()
                    .url("https://cas.hfut.edu.cn/cas/login?service=http%3A%2F%2Fjxglstu.hfut.edu.cn%2Feams5-student%2Fneusoft-sso%2Flogin")
                    .build()
                Log.d("失败","s111")

                    val response = client.newCall(request).execute()
                    Log.d("测试","111")
                    Log.d("测试", response.toString())


            }
        }


                }


