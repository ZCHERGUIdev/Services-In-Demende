package com.zakariachergui.Services

import android.app.LauncherActivity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat.getSystemService
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.parse.ParseUser
import com.zakariachergui.Services.Fragments.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.order_fragment.*

class MainActivity : AppCompatActivity() , AHBottomNavigation.OnTabSelectedListener{
    var ACSESSLOCATIONREQUESTCODE=200
    var location:Location?=null
    companion object {
        fun newInstance() = MainActivity()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.nav.setOnTabSelectedListener(this)
        this.creattabs()
       // permissionCheck()
          var intent=intent
        Toast.makeText(this.baseContext,"Welcom "+ParseUser.getCurrentUser().username.toString(),Toast.LENGTH_LONG).show()
    }

    fun creattabs() {

        var home = AHBottomNavigationItem(getString(R.string.home),R.drawable.home)
        var order = AHBottomNavigationItem(getString(R.string.order),R.drawable.order)
        var Account = AHBottomNavigationItem( getString(R.string.account),R.drawable.account)
        var menu = AHBottomNavigationItem(getString(R.string.menu),R.drawable.menu)

        //nav.isBehaviorTranslationEnabled=false
        nav.addItem(home)
        nav.addItem(order)
        nav.addItem(Account)
        nav.addItem(menu)


//        nav.defaultBackgroundColor = Color.parseColor("#ffffff")
  //      nav.accentColor = Color.parseColor("#09091a")
    //    nav.inactiveColor = Color.parseColor("#c0c0c8")

        nav.defaultBackgroundColor = Color.parseColor("#ffffff")
        nav.accentColor = Color.parseColor("#0389ff")
        nav.inactiveColor = Color.parseColor("#c0c0c8")
        nav.currentItem = 0


    }
    override fun onTabSelected(position: Int, wasSelected: Boolean): Boolean {

        when (position) {
            0 -> {
                val frg1 = HomeFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container,frg1).commit()
            }
            1 -> {
                val frg1 = OrderFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container,frg1).commit()
            }
            2 -> {
                val frg1 = AccountFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container,frg1).commit()
            }
            3 -> {

               val frg1 = MenuFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container,frg1).commit()
            }

        }

        return true
    }
    fun permissionCheck(){
        if(Build.VERSION.SDK_INT>=23){
            if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
                requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),ACSESSLOCATIONREQUESTCODE)
                return
            }
        }
    GetCurrentLocation()
    }

     fun GetCurrentLocation() {
        Toast.makeText(this.baseContext, "User enable the location service", Toast.LENGTH_LONG)
            .show()
        var maplocationlistener =Maplocationlistner(this.baseContext)
        var locationmanager= getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationmanager.requestLocationUpdates(LocationManager.GPS_PROVIDER,3,3f,maplocationlistener)
    }

    inner class Maplocationlistner:LocationListener{
        var context:Context?=null
        constructor(context: Context):super(){
            location= Location("super")
            location!!.latitude=0.0
            location!!.longitude=0.0
            this.context=context


        }
        override fun onLocationChanged(location: Location?) {
         Toast.makeText(this.context,"has been changed location to"+location!!.latitude+" "+location!!.longitude,Toast.LENGTH_LONG).show()
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        }

        override fun onProviderEnabled(provider: String?) {
        }

        override fun onProviderDisabled(provider: String?) {
        }


    }


}