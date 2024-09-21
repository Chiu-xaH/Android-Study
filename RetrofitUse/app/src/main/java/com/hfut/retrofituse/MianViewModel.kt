package com.hfut.retrofituse

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.flow

import kotlinx.coroutines.launch
///创建MainViewModel类，进行数据的请求处理
class MianViewModel : ViewModel() {
    var mainlivedata = MutableLiveData<String>()
    val api = RetrofitUtil.create(ApiService::class.java)

    fun getQueryByName(){
        viewModelScope.launch {
            flow {
                emit(api.queryByName("Retrofit"))
            }.collect {
                mainlivedata.postValue(it)
            }
        }
    }

    fun getTest(){
        viewModelScope.launch {
            flow {
                emit(api.test())
            }.collect {
                mainlivedata.postValue(it)
            }
        }
    }



}