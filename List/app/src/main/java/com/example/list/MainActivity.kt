package com.example.list

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.list.ui.theme.ListTheme

class MainActivity : ComponentActivity() {
    private val list = listOf("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18")//声明数据
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val shipeiqi = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list)
        val lv : ListView = findViewById(R.id.lv)
        lv.adapter = shipeiqi
                }
            }
