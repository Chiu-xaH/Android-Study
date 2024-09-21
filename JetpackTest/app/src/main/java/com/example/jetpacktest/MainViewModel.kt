package com.example.jetpacktest

import android.view.animation.Transformation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//LiveData
class MainViewModel(sz:Int) : ViewModel() {
    val number : LiveData<Int>
        get() = _number //隐秘写法

    private val _number = MutableLiveData<Int>()
    init { _number.value = sz }

    fun plus()  {
        val count = number.value ?: 0
        _number.value = count + 1
    }

    fun clear() { _number.value = 0 }


}