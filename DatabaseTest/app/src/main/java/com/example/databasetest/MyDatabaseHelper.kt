package com.example.databasetest

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class MyDatabaseHelper(val context : Context, name : String,version : Int)
    : SQLiteOpenHelper(context,name,null,version){
    val createBook = "create table Book ("+
            " id integer primary key autoincrement," +
            "author text," +
            "price real," +
            "pages integer," +
            "name text )"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createBook)
        Toast.makeText(context,"创建数据库成功",Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}