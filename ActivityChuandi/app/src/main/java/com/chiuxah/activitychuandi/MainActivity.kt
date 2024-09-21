package com.chiuxah.activitychuandi

import android.content.Intent
import android.os.Bundle
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
import com.chiuxah.activitychuandi.ui.theme.ActivityChuandiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val b : Button = findViewById(R.id.button)
        b.setOnClickListener {
            val it : Intent = Intent(this,MainActivity2::class.java)
            it.putExtra("数据","传递过去啦")
            startActivity(it)
        }
                }
            }

