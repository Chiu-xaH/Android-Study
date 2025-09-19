package com.chiuxah.xposeddemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chiuxah.xposeddemo.ui.theme.XposedDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(!isModuleActive()) {
            Toast.makeText(this,"模块已经启动",Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this,"模块未能启动",Toast.LENGTH_SHORT).show()
        }
    }
    private fun isModuleActive() : Boolean {
        return false
    }
}
