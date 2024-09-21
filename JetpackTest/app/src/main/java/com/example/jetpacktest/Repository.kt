package com.example.jetpacktest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object Repository {

    fun users(id : String) : LiveData<User> {
        val ld = MutableLiveData<User>()
        ld.value = User(id,id,0)
        return ld
    }
}