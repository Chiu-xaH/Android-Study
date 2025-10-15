package com.example.lifedemo

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    private val binder = LocalBinder()

    inner class LocalBinder : Binder() {
        fun getService() = this@MyService
    }

    override fun onBind(intent: Intent): IBinder {
        Log.d("Service","onBind")
        return binder
    }

    fun getMsg() = "This is Service"
}