package com.example.jetpacktest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 2, entities = [User::class,Book::class])
abstract class DB : RoomDatabase() {
    abstract fun shit() : Dao
    abstract fun book2() : Dao2

    companion object {
        var i : DB? = null

        @Synchronized
        fun get(context : Context) : DB {
            //判断i变量是否为空
            i?.let { return it }//i非空
            return Room.databaseBuilder(context.applicationContext,DB::class.java,"数据库").build().apply { i = this }//i空
        }
    }
}
