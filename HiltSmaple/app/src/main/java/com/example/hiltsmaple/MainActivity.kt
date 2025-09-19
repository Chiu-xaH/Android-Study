package com.example.hiltsmaple

import android.os.Bundle
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var target : Target

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        target.print()
//        enableEdgeToEdge()
//        setContent {
//            HiltSmapleTheme {
//
//            }
//        }
    }
}

class Target @Inject constructor() {
    fun print() {
        println("HELLO HILT")
    }
}
