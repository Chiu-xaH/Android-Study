package com.sample.client.activity

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.sample.client.ui.UI
import com.sample.shared.IRemoteAidlInterface
import com.sample.shared.ui.theme.AIDLSampleTheme

class MainActivity : ComponentActivity() {
    var result by mutableStateOf<String?>(null)

    private var remoteService: IRemoteAidlInterface? = null

    companion object {
        private const val SERVER_PACKAGE_NAME = "com.sample.server"
    }

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
            remoteService = IRemoteAidlInterface.Stub.asInterface(binder)
            result = remoteService?.hello("Client端")
            Log.d("SClient", "Result: $result")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            remoteService = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(IRemoteAidlInterface::class.java.name).apply {
            setPackage(SERVER_PACKAGE_NAME)
        }
        val bound = bindService(intent, serviceConnection, BIND_AUTO_CREATE)
        Log.d("SClient", "Bind result: $bound")

        enableEdgeToEdge()
        setContent {
            AIDLSampleTheme {
                UI(result)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(serviceConnection)
    }
}