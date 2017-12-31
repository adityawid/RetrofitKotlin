package com.devjurnal.listrecyclerkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    // pilih yang arrayof agar dapat di set & get array
    // arraylistof hanya dapat mengambil data
    // satu tipe data
//    var data = arrayOf<String>("Alpukat","Apel","Durian", "Mangga")
    // multi tipe data
//    var data = arrayOf("Alpukat","Apel","Durian", "Mangga", 100)

    var data = arrayOf("Alpukat","Apel","Durian", "Mangga", 100)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        // include array ke adapter
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,data)

        // adapter include to listView
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            Log.d("get position", data.get(position).toString())
        }

        // versi javanya
        // listView.setAdapter(adapter)

    }
}
