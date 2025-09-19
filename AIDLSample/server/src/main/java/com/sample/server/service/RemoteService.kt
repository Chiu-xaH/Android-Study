package com.sample.server.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.sample.shared.IRemoteAidlInterface

class RemoteService : Service() {
    private val binder = object : IRemoteAidlInterface.Stub() {
        override fun hello(s: String): String {
            return "Server端 $s"
        }
    }

    override fun onBind(intent: Intent): IBinder {
        Log.d("SServer", "RemoteService onBind called")
        return binder
    }
}