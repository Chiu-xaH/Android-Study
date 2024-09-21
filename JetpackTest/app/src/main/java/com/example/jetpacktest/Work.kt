package com.example.jetpacktest

import android.content.Context
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.Worker
import androidx.work.WorkerParameters

class Work (context : Context,params: WorkerParameters ) : Worker(context, params) {
    override fun doWork(): Result {
        Log.d("测试","已执行")
        //此处写入后台的操作
        return Result.success()
    }

}