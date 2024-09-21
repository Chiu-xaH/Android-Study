package com.example.servicetest

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.servicetest.ui.theme.ServiceTestTheme
import java.security.Provider.Service

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    lateinit var db : MyService.DBinder

    val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            db  = service as MyService.DBinder
            db.start()
            db.get()

        }

        override fun onServiceDisconnected(name: ComponentName?) {

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val b : Button = findViewById(R.id.b)
        val b2 : Button = findViewById(R.id.b2)
        val b3 : Button = findViewById(R.id.b3)
        val b4 : Button = findViewById(R.id.b4)
        val b5 : Button = findViewById(R.id.b5)

        b.setOnClickListener {
            val it = Intent(this,MyService::class.java)
            startService(it)
        }

        b2.setOnClickListener {
            val it = Intent(this,MyService::class.java)
            stopService(it)
        }

        b3.setOnClickListener {
            val it = Intent(this,MyService::class.java)
            bindService(it,connection, Context.BIND_AUTO_CREATE)
        }

        b4.setOnClickListener {
            val it = Intent(this,MyService::class.java)
            unbindService(connection)
        }

        b5.setOnClickListener {
            val it = Intent(this,MyIntentService::class.java)
            startService(it)
            Log.d("测试99","测试99")
        }

                }
            }