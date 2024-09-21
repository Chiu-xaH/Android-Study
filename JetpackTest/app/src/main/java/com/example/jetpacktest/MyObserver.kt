package com.example.jetpacktest

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
//检测活动用
class MyObserver(lc : Lifecycle) : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun Start() {
        Log.d("测试1","Activity,启动")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun Stop() {
        Log.d("测试2","Activity,销毁")
    }
}