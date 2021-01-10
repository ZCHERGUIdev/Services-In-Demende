package com.zakariachergui.Services.Fragments

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.zakariachergui.Services.MapsOrderActivity
import com.zakariachergui.Services.Model.Place
import com.zakariachergui.Services.R

class HomeViewModel(itemView:View) : RecyclerView.ViewHolder(itemView) {
    var data: Place?=null
    var  img: ImageView =itemView.findViewById<View>(R.id.itemImageView)  as ImageView
    var name: TextView =itemView.findViewById<View>(R.id.itemNameView) as TextView
    companion object {
        var nameSer = "name"
    }
      init {
          itemView.setOnClickListener {
              var int=Intent(itemView.context, MapsOrderActivity::class.java)
              int.putExtra(nameSer,data!!.name)
              itemView.context.startActivity(int)
          }
      }
}