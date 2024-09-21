package com.hfut.asyncawaitdemo

import android.os.Bundle
import android.util.Log
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
import com.hfut.asyncawaitdemo.ui.theme.AsyncAwaitDemoTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        suspend fun plus(a : Int,b : Int) : Int{
            val c =  a + b
            delay(1000)
            return c
        }

        suspend fun s(a : Int,b : Int) : Int{
            val c =  (a * b)*5
            delay(2000)
            return c
        }
        setContent {
            AsyncAwaitDemoTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Button(onClick = {
                      CoroutineScope(Job()).launch {
                          async {
                              val start = System.currentTimeMillis()
                              val result = s(55,55)
                              val end = System.currentTimeMillis()
                              Log.d("www",result.toString() + "执行时间${ end - start }")
                          }.await()

                          async {
                              val start = System.currentTimeMillis()
                              val result = plus(532,943253)
                              val end = System.currentTimeMillis()
                              Log.d("计算",result.toString()+ "执行时间${ end - start }")
                          }.await()

                          async {
                              Log.d("全部完毕","a")
                          }


                      }



                   }) {
                       Text(text = "协程")
                   }
                }
            }
        }
    }
}

