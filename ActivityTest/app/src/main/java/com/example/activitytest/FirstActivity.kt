package com.example.activitytest

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
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
import com.example.activitytest.ui.theme.ActivityTestTheme

class FirstActivity() : BaseActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FirstActivity> {
        override fun createFromParcel(parcel: Parcel): FirstActivity {
            return FirstActivity(parcel)
        }

        override fun newArray(size: Int): Array<FirstActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FirstActivity", this.toString())//新增
        setContentView(R.layout.first_layout)
        val button1 : Button = findViewById(R.id.button1)
        button1.setOnClickListener {//第一个按钮点击事件
            //finish()//点击后结束活动
            Toast.makeText(this, "已进入 Activity 2", Toast.LENGTH_SHORT).show()
            val data = "嗨害"
            intent.putExtra("extra_data",data)
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "你点击了第一选项",Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this,"你点击了第二选项",Toast.LENGTH_SHORT).show()
        }
        return true
    }
}