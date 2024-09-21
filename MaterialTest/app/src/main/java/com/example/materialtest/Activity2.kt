package com.example.materialtest

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.Glide
import com.example.materialtest.ui.theme.MaterialTestTheme


class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout2)
        val tb2 : androidx.appcompat.widget.Toolbar = findViewById(R.id.tb2)
        val tv5 : TextView = findViewById(R.id.tv5)
        val ctl : com.google.android.material.appbar.CollapsingToolbarLayout = findViewById(R.id.ctl)
        val iv2 : ImageView = findViewById(R.id.iv2)

        val fruitName = intent.getStringExtra("fruit_name") ?: ""
        val fruitImageId = intent.getIntExtra("fruit_image_id", 0)

        setSupportActionBar(tb2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //启用Home按钮

        ctl.title = fruitName
        Glide.with(this).load(fruitImageId).into(iv2)

        tv5.text = shit(fruitName) //定义函数
                }

    //Home按钮点击操作
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun shit(fruitName: String) = fruitName.repeat(500)
    // 循环拼接字符串
            }
