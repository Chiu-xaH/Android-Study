package com.example.fragment

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fragment.ui.theme.FragmentTheme

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val leftFragment = LeftFragment()
        val rightFragment = RightFragment()
        //val b : Button = findViewById(R.)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.leftFrag, leftFragment)
            replace(R.id.rightFrag, rightFragment)
            commit()
        }

    }
            }


