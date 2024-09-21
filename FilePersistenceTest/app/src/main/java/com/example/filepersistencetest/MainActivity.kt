package com.example.filepersistencetest

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
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
import com.example.filepersistencetest.ui.theme.FilePersistenceTestTheme
import java.io.BufferedWriter
import java.io.IOError
import java.io.IOException
import java.io.OutputStreamWriter

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val b : Button = findViewById(R.id.b)
        b.setOnClickListener {
            val et : EditText = findViewById(R.id.et)
            val input = "et.text.toString()"
            Log.d("检测1","$input")
            //val input = "aaaaa"
            save(input)

            Toast.makeText(this,"已保存",Toast.LENGTH_SHORT).show()
        }
                }




    fun save(input : String) {
            val output = openFileOutput("a",Context.MODE_PRIVATE)
            val writter = BufferedWriter(OutputStreamWriter(output))
            writter.use { it.write(input) }
//标准写法
    }
            }

