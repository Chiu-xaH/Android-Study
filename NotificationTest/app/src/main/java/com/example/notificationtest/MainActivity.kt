package com.example.notificationtest

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.NotificationCompat
import com.example.notificationtest.ui.theme.NotificationTestTheme
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ServiceCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val intent = Intent(this,MainActivity::class.java)
        val pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val m = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val c = NotificationChannel("CA","渠道A",NotificationManager.IMPORTANCE_DEFAULT)
        val c2 = NotificationChannel("CA2","渠道2",NotificationManager.IMPORTANCE_HIGH)

        m.createNotificationChannel(c)
        m.createNotificationChannel(c2)

        val notice = NotificationCompat.Builder(this,"CA2")
            .setContentTitle("标题")
            .setContentText("内容")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.ic_launcher_background))
            .setContentIntent(pi)
            .setAutoCancel(true)//点击后通知消失
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("这是一段长文本啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊"))
            .build()


        val b : Button = findViewById(R.id.button)
        b.setOnClickListener {
            m.notify(1,notice)
        }
    }
}

