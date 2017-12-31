package com.devjurnal.listrecyclerkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_buah.view.*

/**
 * Created by DevJurnal on 12/30/17.
 */
class CustomAdapter(gambar: Array<Int>, nama: Array<String>, rating: Array<Any>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    lateinit var gambar : Array<Int>
    lateinit var nama : Array<String>
    lateinit var rating:Array<Any>
    // inisialisasi List
    init{
        this.gambar=gambar
        this.nama = nama
        this.rating= rating
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        // set null safe pada parent.context dengan menambah ?
        var view =LayoutInflater.from(parent?.context).inflate(R.layout.item_buah, parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nama.size
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        // alt+enter. Create member function
        holder?.bind(position,gambar,nama,rating)
    }

    // itemView : View adalah constructor
    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int, gambar: Array<Int>, nama: Array<String>, rating: Array<Any>) {
            itemView.ivGambarItem.setImageResource(gambar.get(position))
            itemView.textBuahItem.text = nama.get(position)
//            itemView.textBuahItem.setText(nama.get(position))

            itemView.ratingBuahItem.rating = rating.get(position).toString().toFloat()
        }


    }
}