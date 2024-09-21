package com.hfut.cookiedemo

import okhttp3.Request
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    //@Headers("Cookie: cas/checkInitParams?_=1698132494289 LOGIN_FLAVORING=xxxxxxxxxxxxxxxxxxxxxx")
    @GET ("cas/session/setSessionExpire")
    //@Headers("")
    fun get() : Call<ResponseBody>
    @POST ("/")
    fun getCookie() : Request

}