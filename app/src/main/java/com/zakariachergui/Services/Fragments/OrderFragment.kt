package com.zakariachergui.Services.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.zakariachergui.Services.MainActivity
import com.zakariachergui.Services.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.order_fragment.*
import kotlinx.android.synthetic.main.toolbar.*


class OrderFragment :  Fragment() {

    companion object {
        fun newInstance() = OrderFragment()
        fun inst()=MainActivity()
    }

    private lateinit var viewModel: OrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.order_fragment, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      toolText.text="Orders"
        btnOrderNow.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val frg1 = HomeFragment()
                val frg2 = OrderFragment()
                nav.setOnNavigationPositionListener(
                    object : AHBottomNavigation.OnNavigationPositionListener {
                        override fun onPositionChange(y: Int) {
                            nav.currentItem=y
                        }

                    })
                //   fragmentManager!!.beginTransaction().add(R.id.zaki, frg1).commit()
                Toast.makeText(this@OrderFragment.context, "sqdsdffqsfd", Toast.LENGTH_LONG).show()
            }
        })

    }








//           Toast.makeText(newInstance().context,"sqdsdffqsfd",Toast.LENGTH_LONG).show()
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OrderViewModel::class.java)


        // TODO: Use the ViewModel
    }




}