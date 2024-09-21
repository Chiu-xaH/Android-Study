package com.example.servicetest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.core.app.NotificationCompat

class MyService : Service() {

    val mB = DBinder()
    class DBinder : Binder() {
        fun start() {
            Log.d("开始下载","开始下载")
        }
        fun get() : Int {
            Log.d("下载进度","下载进度")
            return 0
        }
    }

    override fun onBind(intent: Intent): IBinder {
       return mB
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()

        //通知标准写法
        val m = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val c = NotificationChannel("CA2","渠道A",NotificationManager.IMPORTANCE_DEFAULT)
        m.createNotificationChannel(c)
        val it = Intent(this,MainActivity::class.java)
        val pi = PendingIntent.getActivity(this, 0, it, PendingIntent.FLAG_IMMUTABLE)
        val notice = NotificationCompat.Builder(this,"CA2")
            .setContentTitle("标题")
            .setContentText("内容")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.ic_launcher_background))
            .setContentIntent(pi)
            .build()
        //通知标准写法   结束
        startForeground(1,notice)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
        Log.d("启动服务2","启动服务2")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("启动服务3","启动服务3")
    }
}