package com.example.uiweighttest

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.uiweighttest.ui.theme.UIweightTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1 : Button = findViewById(R.id.button1)
        val button2 : Button = findViewById(R.id.button2)
        val button3 : Button = findViewById(R.id.button3)
        val button4 : Button = findViewById(R.id.button4)
        val editText : EditText = findViewById(R.id.editText)
        val imageview : ImageView = findViewById(R.id.imageView)
        val progressBar : ProgressBar = findViewById(R.id.progressBar)
        button1.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("对话框")
                setCancelable(false)
                setPositiveButton("好") {
                    dialog,which ->
                }
                setNegativeButton("取消") {
                    dialog,which ->
                }
                show()
            }

        }
        button2.setOnClickListener {
            imageview.setImageResource(R.drawable.img_2)
        }
        button3.setOnClickListener {
            val input = editText.text.toString()
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show()
        }
        button4.setOnClickListener {
            //if(processBar.visibility == View.VISIBLE) processBar.visibility = View.GONE
            //else processBar.visibility = View.VISIBLE

            progressBar.progress += 10
        }


    }
}

