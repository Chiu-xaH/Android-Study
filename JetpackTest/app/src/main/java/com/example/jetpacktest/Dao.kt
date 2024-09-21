package com.example.jetpacktest

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao {
    @Insert
    fun add(user : User) : Long

    @Update
    fun update(new : User)

    @Delete
    fun del(user: User)

    @Query("SELECT * FROM User")
    fun queryall() : List<User>

    @Query("SELECT * FROM User WHERE ln = :ln")
    fun query(ln : String) : Int
}