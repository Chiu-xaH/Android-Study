package com.example.permissionx

import android.app.Application
import android.content.Context

class APP : Application() {
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}