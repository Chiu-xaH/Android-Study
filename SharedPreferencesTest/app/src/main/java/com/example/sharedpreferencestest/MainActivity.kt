package com.example.sharedpreferencestest

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
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
import com.example.sharedpreferencestest.ui.theme.SharedPreferencesTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main)
        val b : Button = findViewById(R.id.B)
        val c : Button = findViewById(R.id.C)

        b.setOnClickListener {
            Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show()
            val editor = getSharedPreferences("数据",Context.MODE_PRIVATE).edit()
            editor.putString("测试","测试2")
            editor.apply()
        }

        c.setOnClickListener {
            val prefs = getSharedPreferences("数据",Context.MODE_PRIVATE)
            val names = prefs.getString("测试","测试2")
            Log.d("日志","$names")
            Toast.makeText(this,"成功",Toast.LENGTH_SHORT).show()
        }
                }
            }


