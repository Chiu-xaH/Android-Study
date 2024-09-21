package com.example.playaudiotest

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.net.Uri
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
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.compose.ui.tooling.preview.Preview
import com.example.playaudiotest.ui.theme.PlayAudioTestTheme
import java.lang.ref.Cleaner.create

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    val mp = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val b : Button = findViewById(R.id.b)
        val b2 : Button = findViewById(R.id.b2)
        val b3 : Button = findViewById(R.id.b3)

        initMP()

        b.setOnClickListener {
            mp.start()
        }

        b2.setOnClickListener {
            mp.pause()
        }

        b3.setOnClickListener {
            mp.reset()
        }

                }

    fun initMP() {
        val a = assets
        val fd = a.openFd("蔡依林 - 恶之必要.mp3")
        mp.setDataSource(fd.fileDescriptor,fd.startOffset,fd.length)
        mp.prepare()
    }

    override fun onDestroy() {
        super.onDestroy()
        mp.stop()
        mp.release()
    }
            }
