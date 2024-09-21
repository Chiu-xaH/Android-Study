package com.example.retrofittest

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
import com.example.retrofittest.ui.theme.RetrofitTestTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App(val id : String,val name: String,val version: String)

class Data(val id : String,val content : String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val b : Button = findViewById(R.id.b)
        b.setOnClickListener {
           // val rf = Retrofit.Builder()
               // .baseUrl("http://10.0.2.2")
              //  .addConverterFactory(GsonConverterFactory.create())
              //  .build()
           // val service = rf.create(Service::class.java)
            val service = Creator.create(Service::class.java)
            service.get().enqueue(object  : Callback<List<App>> {
                override fun onResponse(call: Call<List<App>>,response: Response<List<App>>) {
                    val list = response.body()
                    if (list != null) {
                        for (app in list) {
                            Log.d("测试A1","id是 ${app.id}")
                            Log.d("测试A2","name是 ${app.name}")
                            Log.d("测试A3","version是 ${app.version}")
                        }
                    }
                }

                override fun onFailure(call: Call<List<App>>, t: Throwable) {
                    t.printStackTrace()
                }
            } )
        }
                }
            }
