package com.example.servicetest

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyIntentService : IntentService("MyIt")  {
    override fun onHandleIntent(intent: Intent?) {
        Log.d("测试1","${Thread.currentThread().name}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("测试2","已经结束")
    }
}