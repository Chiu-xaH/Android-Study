package com.example.activitylifecycletest

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
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
import com.example.activitylifecycletest.ui.theme.ActivityLifeCycleTestTheme

class MainActivity : ComponentActivity() {
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        val tempData = "Something you  just typed"
        outState.putString("data_key" , tempData)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag,"onCreate")
        setContentView(R.layout.axctivity_main)
        if (savedInstanceState != null) {
            val tempData = savedInstanceState.getString("data_key")
            Log.d(tag,"tempData is $tempData")
        }
        val startNormalActivity : Button = findViewById(R.id.startNormalActivity)
        startNormalActivity.setOnClickListener {
            val intent = Intent(this, NormalActivity::class.java)
            startActivity(intent)
        }
        val startDialogActivity : Button = findViewById(R.id.startDialogActivity)
        startDialogActivity.setOnClickListener {
            val intent = Intent(this,DialogActivity::class.java)
            startActivity(intent)
        }
            }
    val tag = "MainActivity"

    override fun onStart() {
        super.onStart()
        Log.d(tag,"onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag,"onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d(tag,"onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag,"onDestroy")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d(tag,"onRestart")
    }


        }
