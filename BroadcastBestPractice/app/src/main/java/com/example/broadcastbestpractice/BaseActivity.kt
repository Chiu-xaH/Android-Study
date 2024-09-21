package com.example.broadcastbestpractice

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity

open class BaseActivity : ComponentActivity() {
    lateinit var receiver : Receiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollecter.addActivity(this)
    }

    override fun onResume() {
        super.onResume()
        val iF = IntentFilter()
        iF.addAction("com.example.broadcastbestpractice.BUTTON")
        receiver = Receiver()
        registerReceiver(receiver,iF)//条用广播
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollecter.removeActivity(this)
    }
    inner class Receiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            //强制下线操作
            val a = AlertDialog.Builder(context)
                a.setTitle("警告")
                a.setMessage("您被强制下线，请重新登录")
                a.setCancelable(false)
                a.setPositiveButton("好好好") { _,_ ->
                    ActivityCollecter.finishAll()
                    val i = Intent(context, LoginActivity::class.java)
                    if (context != null) {
                        context.startActivity(i)
                    }
                }
                a.show()
            }
        }
    }

