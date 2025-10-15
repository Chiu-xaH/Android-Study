package com.xah.hotfix.sample.application

import android.app.Application
import android.content.Context
import com.xah.hotfix.sample.activity.applyPatch

class MyApplication : Application() {
    companion object {
        lateinit var context : Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        applyPatch()
    }
}