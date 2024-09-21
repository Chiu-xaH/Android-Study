package com.example.tabrowtext

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tabrowtext.ui.theme.TabRowTextTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ArtistCard()
            TabScreen()
        }
                }
    @Composable
    fun TabScreen() {
        TabRow(selectedTabIndex = 0) {
            Tab(selected = true, onClick = { Toast.makeText(this@MainActivity,"您点击了选项卡1",Toast.LENGTH_SHORT).show() }, content = {
                Text("测试1")
            })
            Tab(selected = true, onClick = { Toast.makeText(this@MainActivity,"您点击了选项卡2",Toast.LENGTH_SHORT).show() }, content = {
                Text("测试2", color = Color.Green, fontSize = TextUnit.Unspecified)
            })
            }
        }

        @Composable
        fun ArtistCard() {
            Text("Alfred Sisley")
            //Text("3 minutes ago")
        }
    }




