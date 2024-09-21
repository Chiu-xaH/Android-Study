package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId", "Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val b : Button = findViewById(R.id.b)
        val b2 : Button = findViewById(R.id.b2)
        val b3 : Button = findViewById(R.id.b3)
        val b4 : Button = findViewById(R.id.b4)
        val b5 : Button = findViewById(R.id.b5)
        val b6 : Button = findViewById(R.id.b6)

        val d = Database(this,"B.db",2)

        b.setOnClickListener {
            d.writableDatabase
        }

        b2.setOnClickListener {
            val db = d.writableDatabase
            val v1 = ContentValues().apply {
        

                put("name","The Da Vinci Code")
                put("author","Dan Brown")
                put("pages","114514")
                put("price","888")
            }
            db.insert("Book",null,v1)
        }

        b3.setOnClickListener {
            val db2 = d.writableDatabase
            val v2 = ContentValues()
            v2.put("price","SHIT")
            db2.update("Book",v2,"name = ?", arrayOf("The Da Vinci Code"))
        }

        b4.setOnClickListener {
            val db3 = d.writableDatabase
            db3.delete("Book",null,null)

        }

        b5.setOnClickListener {
            val db4 = d.writableDatabase
            val v3 = ContentValues().apply {
                put("name","Game of Thrones")
                put("author","Googre")
                put("pages",720)
                put("price",0.85)
            }
            db4.insert("Book",null,v3)
        }

        b6.setOnClickListener {
            val db5 = d.writableDatabase
            val v4 = db5.query("Book",null,null,null,null,null,null)
            if (v4.moveToFirst()) {
                do {
                    val name = v4.getString(v4.getColumnIndex("name"))
                    Log.d("主程序测试","$name")
                } while (v4.moveToNext())
            }
            v4.close()
        }

                }
            }
