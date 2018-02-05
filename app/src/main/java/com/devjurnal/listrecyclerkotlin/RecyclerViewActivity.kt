package com.devjurnal.listrecyclerkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.devjurnal.listrecyclerkotlin.Network.ConfigRetrofit
import com.devjurnal.listrecyclerkotlin.Response.ResponseServer
import kotlinx.android.synthetic.main.activity_recycler_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RecyclerViewActivity : AppCompatActivity() {

    //deklarasi variabel
    var gambar = arrayOf(R.drawable.alpukat,
            R.drawable.durian,
            R.drawable.ceri,
            R.drawable.apel)

    var nama = arrayOf("Alpukat", "durian", "ceri" , "apel")
    var rating = arrayOf(2,2,3.5,4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        // get configuration Retrofit
        // todo (1) Retrofit CONFIGRetrofit.kt
        // TODO 2 buat api service.kt
        // TODO (3) implementasi retrofit
        // Get Config Retrofit
        var getConfig = ConfigRetrofit().service

        //get Request Retrofit
        var getRequest = getConfig.request_wisata()



        // TODO (4) object>> pilih yang annonymous class
        // ganti Callback >>>> Alt+Enter
        getRequest.enqueue(object : Callback<ResponseServer> {
            override fun onFailure(call: Call<ResponseServer>?, t: Throwable?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                Log.d("Eror server", t?.message)
            }

            override fun onResponse(call: Call<ResponseServer>?, response: Response<ResponseServer>?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Log.d("Response Success", response?.message())

                // Log untuk mendapat data JSON
                // TODO (5) cek response.isSuccessful
                Log.d("Response Success", response?.body().toString())
                if(response?.isSuccessful!!){
                    // get data kalau response server ada
                    // TODO (6) Get All JSON
                    var alljson = response.body()

                    // get jsonarray Semarang
                    var jsonArraySemarang= alljson?.semarang


//                    var xadapter = CustomAdapter(gambar, nama, rating)
                    var adapter = WisataAdapter(jsonArraySemarang)

                    // pindahkan array ke recyclerview di layout
                    recyclerView.adapter = adapter
                    //setting layout manager
                    recyclerView.layoutManager = LinearLayoutManager(applicationContext)

                }
            }
        })

        // call adapter recyclerview

    }
}
