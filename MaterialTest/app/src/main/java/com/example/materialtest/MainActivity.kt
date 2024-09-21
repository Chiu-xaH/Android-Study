package com.example.materialtest

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.GridLayout
import android.widget.Toast
import android.widget.Toolbar

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.listviewtest.Fruit
import com.example.materialtest.ui.theme.MaterialTestTheme
import com.google.android.material.snackbar.Snackbar
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context

import kotlin.concurrent.thread



class MainActivity : AppCompatActivity() {
    //定义数组
    val fruits = mutableListOf(
        Fruit("Apple", R.drawable.apple),Fruit("Mango", R.drawable.mango),
        Fruit("Banana", R.drawable.banana), Fruit("Orange", R.drawable.orange),
        Fruit("Watermelon", R.drawable.watermelon), Fruit("Pear", R.drawable.pear),
        Fruit("Grape", R.drawable.grape), Fruit("Pineapple", R.drawable.pineapple),
        Fruit("Strawberry", R.drawable.strawberry), Fruit("Cherry", R.drawable.cherry)
        )
    val fruitList = ArrayList<Fruit>()

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        //nv是侧边栏，dl是整体布局
       // val nv : com.google.android.material.navigation.NavigationView = findViewById(R.id.nv)
        val dl : androidx.drawerlayout.widget.DrawerLayout = findViewById(R.id.dl)
        val tb : androidx.appcompat.widget.Toolbar = findViewById(R.id.tb)
        val fab : com.google.android.material.floatingactionbutton.FloatingActionButton = findViewById(R.id.fab)
        val rv : androidx.recyclerview.widget.RecyclerView = findViewById(R.id.rv)
        val srl : androidx.swiperefreshlayout.widget.SwipeRefreshLayout = findViewById(R.id.srl)

        setSupportActionBar(tb)//加载ToolBar布局

        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeActionContentDescription(R.drawable.ic_menu)
            //为Tb加载menu/toolbar.xml里的按钮
        }


       // nv.setCheckedItem(R.id.i11)

         //   nv.setNavigationItemSelectedListener {
           //     dl.closeDrawers() //点击侧边按钮后收回面板
           //true
            //}

        fab.setOnClickListener {//view ->

            val it : Intent = Intent(this,TextActivity2::class.java)
            startActivity(it)
           // com.google.android.material.snackbar.Snackbar.make(view,"测你🐎",Snackbar.LENGTH_SHORT).setAction("不测了") {

       //     }.show()
        // 悬浮球点击事件
            //val it : Intent = Intent(context,Activity2::class.java)
            //startActivity(it)
        }

        sb()//定义函数

        val manager = GridLayoutManager(this,2)//两行分布
        rv.layoutManager = manager

        val adapter = Adapter(this,fruitList)//运用适配器导入数据
        rv.adapter = adapter


        //刷新操作
        srl.setColorSchemeColors(R.color.colorPrimary)  //指定颜色
        srl.setOnRefreshListener {
            refresh(adapter)
        }

        }

    private fun sb() {//重复
        fruitList.clear()
        repeat(50) {
            val index = (0 until fruits.size).random()
            fruitList.add(fruits[index])
        }
    }

    private fun refresh(adapter: Adapter) {//刷新操作函数
        thread {
            val srl : androidx.swiperefreshlayout.widget.SwipeRefreshLayout = findViewById(R.id.srl)
            //尼玛的还要在这里再的定义一次
            Thread.sleep(2000)
            runOnUiThread {
                sb()
                adapter.notifyDataSetChanged()
                srl.isRefreshing = false
                Toast.makeText(this,"刷新完成",Toast.LENGTH_SHORT).show()
            }
        }
    }

    //跟menu/toolbar.xml有关，重写方法
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val dl : androidx.drawerlayout.widget.DrawerLayout = findViewById(R.id.dl)
        when (item.itemId) {
            R.id.i01 -> Toast.makeText(this,"备份",Toast.LENGTH_SHORT).show()
            R.id.i02 -> Toast.makeText(this,"删除",Toast.LENGTH_SHORT).show()
            R.id.i03 -> Toast.makeText(this,"设置",Toast.LENGTH_SHORT).show()
            android.R.id.home -> dl.openDrawer(GravityCompat.START)//侧边键Home，指定打开侧边栏openDrawer()方法
        }
        return true
    }

            }
