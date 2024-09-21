package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

 class Database (context: Context, name:String, version:Int) : SQLiteOpenHelper(context,name,null,version) {
    val c = "create table Book ("+
    " id integer primary key autoincrement," +
    "author text," +
    "price real," +
    "pages integer," +
    "name text )"
     val e = "create table Cate (" +
             "id integer primary key autoincrement," +
             "cate_name," +
             "cate_code )"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(c)
        db?.execSQL(e)
        //Toast.makeText(context,"创建数据库成功",Toast.LENGTH_SHORT).show()
    }

     override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
         db?.execSQL("drop table if exists Book")
         db?.execSQL("drop table if exists Cate")
         onCreate(db)
     }
}