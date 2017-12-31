package com.devjurnal.listrecyclerkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnListView.setOnClickListener(this)
        btnRecyclerView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        /*
        * Cara dengan IF ELSE
        if(v == btnListView){


        }
        */

        // when == switch case
        when(v){
            btnListView -> { startActivity(Intent(this, ListViewActivity::class.java))}
            btnRecyclerView ->{ startActivity(Intent(this, RecyclerViewActivity::class.java))}
        }
    }

}
