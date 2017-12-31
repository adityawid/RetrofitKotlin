package com.devjurnal.listrecyclerkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.devjurnal.listrecyclerkotlin.Response.SemarangItem
import kotlinx.android.synthetic.main.item_buah.view.*

/**
 * Created by DevJurnal on 12/31/17.
 */
class WisataAdapter(json: List<SemarangItem?>?) : RecyclerView.Adapter<WisataAdapter.MyViewHolder>() {

     var json : List<SemarangItem?>?
    // inisialisasi List
    init{
        this.json = json
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        // set null safe pada parent.context dengan menambah ?
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.item_buah, parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return json?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        // alt+enter. Create member function
        holder?.bind(position,json)
    }

    // itemView : View adalah constructor
    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int, json: List<SemarangItem?>?) {

            var wisata = json?.get(position)
//            itemView.ivGambarItem.setImageResource(json.get(position))
            itemView.textBuahItem.text = wisata?.namaWisata
            itemView.textAlamat.text = wisata?.alamatWisata
            Glide.with(itemView).load("https://drive.google.com/thumbnail?id="+wisata?.gambarWisata).into(itemView.ivGambarItem)

//            itemView.textBuahItem.setText(nama.get(position))
//            itemView.ratingBuahItem.rating = rating.get(position).toString().toFloat()
        }


    }
}