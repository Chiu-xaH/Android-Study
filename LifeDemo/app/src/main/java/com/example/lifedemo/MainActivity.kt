package com.example.lifedemo

import android.os.HandlerThread
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Popup

class MainActivity : ComponentActivity() {
    private lateinit var myService : MyService
    private var isBound : Boolean? = null

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.d("Connection","Successfully")
            myService = (service as MyService.LocalBinder).getService()
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d("Connection","Failed")
            isBound = false
        }
    }

    override fun onStop() {
        super.onStop()
        if(isBound == true) {
            unbindService(connection)
            isBound = false
        }
        Log.d("Activity","onStop")
    }

    override fun onStart() {
        super.onStart()
        Intent(this, MyService::class.java).also {
            bindService(it,connection,Context.BIND_AUTO_CREATE)
        }
        Log.d("Activity","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Activity","onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity","onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Activity","onRestart")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("Activity","onConfigurationChanged")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", 5)
        Log.d("Activity","onSaveInstanceState")
    }

    private fun getMsg()  =
        if(isBound == true) {
            Log.d("Activity",myService.getMsg())
        } else {
            Log.d("Activity","null")
        }

    val handlerThread = HandlerThread("Example")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Activity","onCreate")
        handlerThread.start()
        val handler = Handler(handlerThread.looper)

//        handlerThread.quitSafely()
        setContent {
            Box(modifier = Modifier.fillMaxSize()) {
                var showPopup by remember { mutableStateOf(false) }

                if (showPopup) {
                    Popup(
                        alignment = Alignment.Center,
                        onDismissRequest = { showPopup = false }
                    ) {
                        Surface(
                            shadowElevation = 8.dp,
                            shape = RoundedCornerShape(8.dp),
                        ) {
                            Column(Modifier.padding(16.dp)) {
                                Text("菜单项 1")
                                Text("菜单项 2")
                            }
                        }
                    }
                }


                Box(modifier = Modifier.align(Alignment.Center)) {
//                    CircleProgressCompose(
//                        progress = 100
//                    )
                    Button(
                        onClick = {
                            handler.post {
                                Log.d("Handler","HandlerThread${handlerThread.threadId}")
                            }
//                            startService(Intent(this@MainActivity, MyIntentService::class.java).apply {
//                                putExtra("data","From MainActivity")
//                            })
//                            showPopup = true
//                            sendBroadcast(Intent("SEND").apply {
//                                setClassName(
//                                    packageName,
//                                    MyReceiver::class.java.name
//                                )
//                            })
                        }
//                            this@MainActivity::getMsg
                    ) {
                        Text("Test")
                    }
                }
            }
        }
    }
}

