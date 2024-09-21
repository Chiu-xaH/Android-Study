package com.hfut.cookiedemo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MyViewModel: ViewModel() {
    var livedata = MutableLiveData<String>()
    val api = ServiceCreator.create(ApiService::class.java)
    fun get() {
        val call = api.get()
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                // 请求成功，获取响应体
                val body = response.body()?.string()
                // 将响应体转换为字符串，并赋值给livedata
                livedata.value = body
                if(response.isSuccessful()) Log.d("测试","成功 ${response.code()}")
                else Log.d("测试","失败，${response.code()},${response.message()}")
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("测试","失")
                t.printStackTrace()
            }
        })
    }


}