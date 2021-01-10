package com.zakariachergui.Services.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.zakariachergui.Services.Fragments.HomeViewModel
import com.zakariachergui.Services.Model.Place
import com.zakariachergui.Services.R


class HomeAdapter(var item:ArrayList<Place>):RecyclerView.Adapter<HomeViewModel>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewModel {
        var v=LayoutInflater.from(parent.context).inflate(R.layout.viewcell,parent,false)
        return HomeViewModel(v)
    }
 // edit data cell
    override fun onBindViewHolder(holder: HomeViewModel, position: Int) {

     try {

         var data= item!![position]
         holder?.data=data
        holder.img.setBackgroundResource(data.image as Int)
         holder.name.text=data.name

     }catch (e:Exception){
          Log.d("data ",e.message )
     } finally {

     }




    }

    override fun getItemCount(): Int {

return item.size
    }

}