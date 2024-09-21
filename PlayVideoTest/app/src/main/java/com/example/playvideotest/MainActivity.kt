package com.example.playvideotest

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.playvideotest.ui.theme.PlayVideoTestTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val vv : VideoView = findViewById(R.id.vv)
        val b : Button = findViewById(R.id.b)
        val b2 : Button = findViewById(R.id.b2)
        val b3 : Button = findViewById(R.id.b3)

        val uri = Uri.parse("android.resource://$packageName/${R.raw.n}")
        vv.setVideoURI(uri)

        b.setOnClickListener {
            vv.start()
        }

        b2.setOnClickListener {
            vv.pause()
        }

        b3.setOnClickListener {
            vv.resume()
        }


                }

    // override fun onDestroy() {
       // super.onDestroy()
       // vv.suspend()
  //  }
            }
