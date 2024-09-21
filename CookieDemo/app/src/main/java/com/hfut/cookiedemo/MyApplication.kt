package com.hfut.cookiedemo

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho

class MyApplication : Application(){
    companion object {lateinit var context : Context }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        context = applicationContext
    }
}