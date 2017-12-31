package com.devjurnal.listrecyclerkotlin.Network

import com.devjurnal.listrecyclerkotlin.Response.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by DevJurnal on 12/31/17.
 */
interface ApiService {

    // TODO 2 buat api service.kt
    // request to Server
    @GET("macros/s/AKfycby-jbgwKHEvnMbXo3yaW86EulRpsP59AAY2_p5CEDsjfIHqtXMK/exec?sheet=semarang")
    fun request_wisata(): Call<ResponseServer>
}