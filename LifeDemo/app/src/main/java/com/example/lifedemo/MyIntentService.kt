package com.example.lifedemo

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log


class MyIntentService : IntentService("MyIntentService") {
    @Deprecated("Deprecated in Java")
    override fun onHandleIntent(intent: Intent?) {
        intent ?: return
        val data = intent.getStringExtra("data")
        Log.d("IntentService",data ?: "null")
    }
}