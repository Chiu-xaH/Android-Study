package com.example.jetpacktest

import androidx.room.Entity
import androidx.room.PrimaryKey

//你🐎的面向对象就是墨迹

@Entity //声明成实体类
data class User(var fn : String,var ln : String,var age : Int) {
    @PrimaryKey(autoGenerate = true) //主键 （自动生成）
    var id : Long = 0
}

@Entity //声明成实体类
data class Book(var name : String,var page : Int) {
    @PrimaryKey(autoGenerate = true) //主键 （自动生成）
    var id : Long = 0
}