package com.example.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.ResultReceiver
import android.widget.Button
import android.widget.TimePicker.OnTimeChangedListener
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.broadcast.ui.theme.BroadcastTheme

class MainActivity : ComponentActivity() {
    var time = TimeChangeReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val button : Button = findViewById(R.id.b)
        button.setOnClickListener {
            val it = Intent("com.example.broadcast.MY_BROADCAST")
            it.setPackage(packageName)
            sendOrderedBroadcast(it,null)
        }
        var iF = IntentFilter()
        time = TimeChangeReceiver()
        iF.addAction("android.intent.action.TIME_TICK")
        registerReceiver(time,iF)
            }
    inner class TimeChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context,"时间",Toast.LENGTH_SHORT).show()
        }
    }
    }

