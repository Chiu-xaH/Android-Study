package com.example.jetpacktest

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
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
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.jetpacktest.ui.theme.JetpackTestTheme
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {

    lateinit var vm : MainViewModel
    lateinit var sp : SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val b : Button = findViewById(R.id.b)
        val b2 : Button = findViewById(R.id.b2)
        val b_add : Button = findViewById(R.id.b_add)
        val b_query : Button = findViewById(R.id.b_query)
        val b_del : Button = findViewById(R.id.b_del)
        val b_queryall : Button = findViewById(R.id.b_queryall)
        val b_update : Button = findViewById(R.id.b_update)
        val b3 : Button = findViewById(R.id.b3)
        val b4 : Button = findViewById(R.id.b4)


        sp = getPreferences(MODE_PRIVATE)
        val zx = sp.getInt("存档",0)


        vm = ViewModelProvider(this,Factory(zx)).get(MainViewModel::class.java)

        b.setOnClickListener {
            //vm.number++
            vm.plus()
           // sb()
        }
        sb()

        b2.setOnClickListener {
            //vm.number = 0
            vm.clear()
           // sb()
        }
        val tv : TextView = findViewById(R.id.tv)
        vm.number.observe(this) { count -> tv.text = count.toString()}
       // lifecycle.currentState

        val user1 = User("Tom","FUCK",88)
        val user2 = User("Bob","SHIT",99)
        val Room = DB.get(this).shit()

        b_add.setOnClickListener {
            thread {
                user1.id = Room.add(user1)
                user2.id = Room.add(user2)
            }
        }

        b_del.setOnClickListener {
            thread {
                Room.del(user1)
            }
        }

        b_query.setOnClickListener {

        }

        b_queryall.setOnClickListener {
            thread {
                for (user in Room.queryall()) {
                    Log.d("查询",user.toString())
                }

            }
        }

        b_update.setOnClickListener {
            thread {
                user1.age = 8888
                Room.update(user1)
            }
        }

        b3.setOnClickListener {
            val request = OneTimeWorkRequest.Builder(Work::class.java)
               // .setInitialDelay(25,TimeUnit.SECONDS)
                .addTag("标签")

                .build()
            WorkManager.getInstance(this).enqueue(request)

        }



                }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("存档",vm.number.value ?: 0)
        }
    }

    private fun sb() {
        val tv : TextView = findViewById(R.id.tv)
        tv.text = vm.number.toString()
    }
            }
