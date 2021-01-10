package com.zakariachergui.Services.Fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zakariachergui.Services.Adapters.HomeAdapter
import com.zakariachergui.Services.MainActivity
import com.zakariachergui.Services.Model.Place
import com.zakariachergui.Services.R
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
     var listItem=ArrayList<Place>()
     // var itemAdapter:ArrayAdapter<Place>?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
   // return inflater.inflate(R.layout.home_fragment, container, false)
         val rotView= inflater.inflate(R.layout.home_fragment, container, false)
         val rv=rotView.findViewById<View>(R.id.recyclerview_item) as RecyclerView
         rv.layoutManager=GridLayoutManager(newInstance().context,2)
         rv.adapter=HomeAdapter(listItem)
         return rotView
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    //    listItem= ArrayList()
        var p1=Place(1,R.drawable.electricien,"Electricien")
        var p2=Place(1,R.drawable.menage,"Menage")
        var p3=Place(1,R.drawable.makla,"Food")
        var p4=Place(1,R.drawable.painter,"Painter")
        var p33=Place(1,R.drawable.cardd,"Painter")
        var p5=Place(1,R.drawable.zoo,"Painter")
        var p6=Place(1,R.drawable.zoo,"Painter")
        var p7=Place(1,R.drawable.zoo,"Painter")
        var p8=Place(1,R.drawable.zoo,"Painter")
        var p9=Place(1,R.drawable.zoo,"Painter")
        var p10=Place(1,R.drawable.zoo,"Painter")
        var p11=Place(1,R.drawable.zoo,"Painter")
        var p12=Place(1,R.drawable.zoo,"Painter")
        var p13=Place(1,R.drawable.zoo,"Painter")
        var p15=Place(1,R.drawable.zoo,"Painter")


        listItem.add(p1)
        listItem.add(p2)
        listItem.add(p3)
        listItem.add(p4)
        listItem.add(p33)
        listItem.add(p5)
        listItem.add(p6)
        listItem.add(p7)
        listItem.add(p8)
        listItem.add(p9)
        listItem.add(p10)
        listItem.add(p11)
        listItem.add(p12)
        listItem.add(p13)
        listItem.add(p15)
     //   recyclerview_item.adapter=HomeAdapter(listItem)

    }






}

