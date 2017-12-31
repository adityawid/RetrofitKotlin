package com.devjurnal.listrecyclerkotlin.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by DevJurnal on 12/31/17.
 */
class ConfigRetrofit {

    // configurasi retrofit
    // todo (1) Retrofit CONFIGRetrofit.kt
    val retrofit = Retrofit.Builder()
//                .baseUrl("https://api.github.com")
            // link :https://script.google.com/macros/s/AKfycby-jbgwKHEvnMbXo3yaW86EulRpsP59AAY2_p5CEDsjfIHqtXMK/exec?sheet=semarang
            .baseUrl("https://script.google.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    // Service yang dipanggil di activity
    val service = retrofit.create<ApiService>(ApiService::class.java!!)

}