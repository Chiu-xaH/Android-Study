package com.example.lifedemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class WorkService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("Service", "onStartCommand")
        val msg = intent?.getStringExtra("msg")
        Log.d("Service", "msg = $msg")
        return START_STICKY
//        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        Log.d("Service", "onCreate")
    }
}