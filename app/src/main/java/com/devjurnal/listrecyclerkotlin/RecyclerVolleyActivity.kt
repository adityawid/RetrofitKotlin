package com.devjurnal.listrecyclerkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.devjurnal.listrecyclerkotlin.Response.SemarangItem
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.activity_recycler_volley.*
import org.json.JSONObject

class RecyclerVolleyActivity : AppCompatActivity() {

    var wisataList : MutableList<SemarangItem>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_volley)
        wisataList = mutableListOf()
        recyclerViewVolley.layoutManager = LinearLayoutManager(applicationContext)
//        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        getDataUser()
    }

    private fun getDataUser() {
        var URL = "https://script.google.com/macros/s/AKfycby-jbgwKHEvnMbXo3yaW86EulRpsP59AAY2_p5CEDsjfIHqtXMK/exec?sheet=semarang"
        val stringRequest = StringRequest(Request.Method.GET, URL, Response.Listener<String>{
            response ->

            val jsonObject = JSONObject(response)
            val array = jsonObject.getJSONArray("semarang")
            Log.d("Response Success", array.toString())

            for (i in 0..array.length() - 1) {
                val json = array.getJSONObject(i)
                val semarangItem = SemarangItem()
                semarangItem.namaWisata = json.getString("nama_wisata")

                wisataList!!.add(semarangItem)
                val adapter = WisataAdapter(wisataList)
                recyclerViewVolley.adapter = adapter
            }

        }, Response.ErrorListener {

        })

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add<String>(stringRequest)
    }
}
