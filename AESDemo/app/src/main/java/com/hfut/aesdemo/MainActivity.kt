package com.hfut.aesdemo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hfut.aesdemo.ui.theme.AESDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val encryptET : EditText = findViewById(R.id.encryptET)
        val keyET : EditText = findViewById(R.id.keyET)
        val tv : TextView = findViewById(R.id.tv)
        val b : Button = findViewById(R.id.b)

        b.setOnClickListener {
            val encryText = encryptET.editableText.toString()
            val keyET = keyET.editableText.toString()
            val result = AES.encrypt(encryText,keyET)
            tv.text = result
        }

            }
        }

