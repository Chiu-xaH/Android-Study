package com.example.networktest

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.networktest.ui.theme.NetworkTestTheme
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONArray
import org.xml.sax.ContentHandler
import org.xml.sax.InputSource
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.StringReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import javax.xml.parsers.SAXParserFactory
import kotlin.concurrent.thread

class App(val id : String,val name: String,val version: String)
class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val b: Button = findViewById(R.id.b)

        b.setOnClickListener {
            thread {

                try {
                    val client = OkHttpClient()
                    val mediaType = "text/plain".toMediaTypeOrNull()
                    val body = RequestBody.create(mediaType, "你要发送的数据")
                    val request = Request.Builder()
                        .url("http://10.0.2.2/b.json")
                        .post(body)
                        .build()
                    val response = client.newCall(request).execute()
                    val reData = response.body?.string()
                    //reData?.let { it1 -> showr(it1) }
                   // reData?.let { it1 -> xml(it1) }
                   // reData?.let { it1 -> sax(it1) }
                    //reData?.let { it1 -> json(it1) }
                    reData?.let { it1 -> gson(it1) }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

        }
    }

    private fun gson(jsonData: String) {
        val g = Gson()
        val type = object  : TypeToken<List<App>>() {}.type
        val list = g.fromJson<List<App>>(jsonData,type)
        for (app in list) {
            Log.d("测试B1","${app.id}")
            Log.d("测试B2","${app.name}")
            Log.d("测试B3","${app.version}")
        }
    }

    private fun json(jsonData : String) {
        try {
            val array = JSONArray(jsonData)
            for (i in 0 until array.length()) {
                val Object = array.getJSONObject(i)
                val id = Object.getString("id")
                val name = Object.getString("name")
                val version = Object.getString("version")
                Log.d("测试A1","$name")
                Log.d("测试A2","$id")
                Log.d("测试A3","$version")
            }
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun sax(xmlData: String) {
        try {
            val factory = SAXParserFactory.newInstance()
            val xmlReader = factory.newSAXParser().xmlReader
            val hander = MyHandler()
            xmlReader.contentHandler = hander
            xmlReader.parse(InputSource(StringReader(xmlData)))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
//这段代码是使用 XmlPullParser 来解析 XML 文件。XmlPullParser 是一种基于事件流的 XML 解析器，它可以按顺序读取 XML 文档中的元素，属性和文本内容，并触发不同的事件。这段代码中，定义了一个 xml 函数，它接受一个字符串参数 xmlData，表示要解析的 XML 数据。函数的主要逻辑如下：
//
//- 首先，创建一个 XmlPullParserFactory 实例，并通过它获取一个 XmlPullParser 实例。
//- 然后，调用 setInput 方法，将 xmlData 转换为 StringReader 并传入 XmlPullParser，这样就可以开始解析了。
//- 接着，定义了四个变量 id, name, version 和 eventType，分别用来存储解析到的应用信息和当前的事件类型。
//- 然后，使用一个 while 循环，不断地获取下一个事件类型，并判断是否到达了文档的结尾。如果没有到达结尾，就根据事件类型进行不同的处理。
//- 当事件类型为 START_TAG 时，表示开始解析某个节点。这时，需要获取节点的名称，并根据名称判断是哪个节点。如果是 id, name 或 version 节点，就调用 nextText 方法，获取节点的文本内容，并赋值给对应的变量。
//- 当事件类型为 END_TAG 时，表示完成解析某个节点。这时，需要判断是否是 employee 节点，如果是的话，就表示已经解析完了一个应用的信息。这时，可以使用 Log.d 方法，将 id, name 和 version 的值打印出来。
//- 最后，调用 next 方法，获取下一个事件类型，并继续循环。
//
//这段代码可以实现对 XML 文件的解析，并将解析结果输出到日志中。
    private fun xml(xmlData: String) {
        try {
            val factory = XmlPullParserFactory.newInstance()
            val xmlPullParser = factory.newPullParser()
            xmlPullParser.setInput(StringReader(xmlData))

            var eventType = xmlPullParser.eventType
            var id = ""
            var name = ""
            var version = ""

            while (eventType != XmlPullParser.END_DOCUMENT) {
                val nodeName = xmlPullParser.name
                when (eventType) {
                    // 开始解析某个节点
                    XmlPullParser.START_TAG -> {
                        when (nodeName) {
                            "id" -> id = xmlPullParser.nextText()
                            "name" -> name = xmlPullParser.nextText()
                            "version" -> version = xmlPullParser.nextText()
                        }
                    }
                    // 完成解析某个节点
                    XmlPullParser.END_TAG -> {
                        if ("app" == nodeName) {
                            Log.d("测试1", "$id")
                            Log.d("测试2", "$name")
                            Log.d("测试3", "$version")
                        }
                    }
                }
                eventType = xmlPullParser.next()
            }
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun showr(response : String) {
        runOnUiThread {
            val tv : TextView = findViewById(R.id.tv)
            tv.text = response
       }
    }

            }