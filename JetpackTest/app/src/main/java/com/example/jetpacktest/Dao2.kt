package com.example.jetpacktest

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao2 {
    @Insert
    fun add(user : Book) : Long

    @Update
    fun update(new : Book)

    @Delete
    fun del(user: Book)

    @Query("SELECT * FROM Book")
    fun queryall() : List<Book>


}