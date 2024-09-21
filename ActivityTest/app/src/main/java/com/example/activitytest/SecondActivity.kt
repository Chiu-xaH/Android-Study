package com.example.activitytest


import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
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
import com.example.activitytest.ui.theme.ActivityTestTheme

class SecondActivity : BaseActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)
        val extraData = intent.getStringExtra("extra_data")
        Log.d("SecondActivity", "extra data is $extraData")
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            Toast.makeText(this, "已打开", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://www.baidu.com")
            startActivity(intent)
        }
        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            Toast.makeText(this, "已关闭", Toast.LENGTH_SHORT).show()

            ActivityCollector.finishAll()
            //android.os.Process.killProcess(android.os.Process.myPid())

        }
        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener {
            Toast.makeText(this, "已打开", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}
