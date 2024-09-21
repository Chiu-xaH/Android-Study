package com.example.contactstest

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.Contacts
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
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
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.contactstest.ui.theme.ContactsTestTheme

class MainActivity : ComponentActivity() {
    private val list = ArrayList<String>()
    private lateinit  var adapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val lv : ListView = findViewById(R.id.lv)
        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        lv.adapter = adapter
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS), 1)
        } else {
            read()
        }
                }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    read()
                } else {
                    Toast.makeText(this, "你拒绝了权限", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    @SuppressLint("Range")
    fun read() {
        //定义函数行为
        contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_FILTER_URI,null,null,null,null)?.apply {
            //list.add("测试")
            //往下出现问题
           while (moveToNext()) {  //Log.d("测试3","ceshi")
               val name = getString(getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
               val number = getString(getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
               //val name = "aaaa"
               //val number = "sssss"
                //Log.d("测试2","ceshi")//往上出现问题
               list.add("$name\n$number")

           }
            adapter.notifyDataSetChanged()
            close()
        }
    }
            }
