package com.zakariachergui.Services

import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseQuery
import com.parse.ParseUser
import com.squareup.picasso.Picasso
import com.zakariachergui.Services.Fragments.HomeViewModel
import com.zakariachergui.Services.Model.Employee
import com.zakariachergui.Services.Model.Place
import com.zakariachergui.Services.Model.User
import kotlinx.android.synthetic.main.info_ofworker.*
import kotlinx.android.synthetic.main.info_ofworker.view.*

class MapsOrderActivity : AppCompatActivity(), OnMapReadyCallback {
    var placeLocetion=ArrayList<Place>()
    private lateinit var mMap: GoogleMap
  //  var location:Location?=null
   // var currentMarker:Marker?=null
 //   var ACSESSLOCATIONREQUESTCODE=200
   var progressDialog:ProgressDialog?=null
var  googleMap:GoogleMap?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        //array of places

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps_order)
        progressDialog=ProgressDialog(this)
        progressDialog!!.setTitle("downloading your location")
        progressDialog!!.setMessage("Pleaze Wait")
        progressDialog!!.show()
        var intent=intent
       var craft= intent.getStringExtra("name")
         getData(craft)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    //    permissionCheck()
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        addPlaces()
    }

    private fun addPlaces() {
        var p1=Place(1,R.drawable.electricien,"Mustapha Stamboli",35.414427,0.1268365)
        var p2=Place(1,R.drawable.menage,"Menage",35.3992096,0.1441682)
        var p3=Place(1,R.drawable.makla,"Food",35.3989479,0.1393044)

        placeLocetion.add(p1)
        placeLocetion.add(p2)
        placeLocetion.add(p3)

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        progressDialog!!.hide()
 /*     for (i in 0..placeLocetion.size-1)
        {val place = LatLng(placeLocetion[i].placeLocation!!.latitude, placeLocetion[i].placeLocation!!.longitude)

            mMap.addMarker(MarkerOptions().position(place).title(placeLocetion[i].name).snippet("Number Phone "+"0792930900"))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(place))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place,10f))
            googleMap.setOnMarkerClickListener ( object :GoogleMap.OnMarkerClickListener{
                override fun onMarkerClick(p0: Marker?): Boolean {

                        showAlertDialog()

                    return true}
            } )
        }
*/

        // Add a marker in Sydney and move the camera
    /*    val mascara = LatLng(35.4021, 0.1400)
        googleMap.setOnMarkerClickListener(this);
        mMap.addMarker(MarkerOptions().position(mascara).title("Marker in Mascara"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mascara))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mascara,15f))  */

    }

    private fun scaleImg(res:Resources,id:Int,minSize:Int): Bitmap {
         var b :Bitmap?=null
        var o=BitmapFactory.Options()
        var o2=BitmapFactory.Options()

        o.inJustDecodeBounds=true
        var scale=1
        var sc=0.0f
        BitmapFactory.decodeResource(res,id,o)
        if (o.outHeight>o.outWidth)
        {
            var sc=(o.outHeight/minSize).toFloat()
            scale= Math.round(sc)
        }else{
            var sc=(o.outWidth/minSize).toFloat()
            scale= Math.round(sc)
        }
        o2.inSampleSize=scale
         b=  BitmapFactory.decodeResource(res,id,o2)
return b
    }

    private fun showAlertDialog(view: View) {
        //var view:View
       // view=layoutInflater.inflate(R.layout.info_ofworker,null)
       var dialog= AlertDialog.Builder(this)
            .setView(view)
        view.setBackgroundResource(R.color.tras)
        dialog.create()
        dialog.show()
    }

    fun doEvnt(view: View) {
        Toast.makeText(this.baseContext,"button clicked",Toast.LENGTH_LONG).show()
    }

/*
    private fun permissionCheck(){
        if(Build.VERSION.SDK_INT>=23){
            if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),ACSESSLOCATIONREQUESTCODE)
                return
            }
        }
        GetCurrentLocation()
    }*/
/*
    private fun GetCurrentLocation() {
        Toast.makeText(this.baseContext, "User enable the location service", Toast.LENGTH_LONG)
            .show()
        var maplocationlistener =Maplocationlistner(this.baseContext)
        var locationmanager= getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationmanager.requestLocationUpdates(LocationManager.GPS_PROVIDER,3,3f,maplocationlistener)
    }
    */
/*    inner class Maplocationlistner: LocationListener {
        var context: Context?=null
        constructor(context: Context):super(){
            location= Location("super")
            location!!.latitude=0.0
            location!!.longitude=0.0
            this.context=context


        }
        override fun onLocationChanged(location: Location?) {
            progressDialog!!.hide()

            Toast.makeText(this.context,"has been changed location to"+location!!.latitude+" "+location!!.longitude,Toast.LENGTH_LONG).show()
       var loc=LatLng(location!!.latitude,location!!.longitude)
            if (currentMarker!=null){
                currentMarker!!.remove()
            }
            currentMarker=mMap.addMarker(MarkerOptions()
                .position(loc)
                .title("I am here")
                .snippet("this is my currentLocation")
            )
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc,16f))
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        }

        override fun onProviderEnabled(provider: String?) {
        }

        override fun onProviderDisabled(provider: String?) {
        }


    }*/


    fun getData(nameCraft:String){
        var query = ParseQuery.getQuery<ParseObject>(Employee::class.java.simpleName)
        //query.orderByDescending("createdAt")
        query.whereEqualTo("craft",nameCraft)
        var item= mutableListOf<Employee>()

        progressDialog!!.show()
        query.findInBackground({ objs, e ->
            if (e==null && objs.size>0){
                var img: ParseFile?=null
                var img2=mutableListOf<ParseFile>()
                progressDialog!!.hide()

                for (i in 0..objs.size-1)
                {
                    //img=objs[i].getParseFile("image")
                   // img2.add(img)
                    //  item[i].image=objs[i].getParseFile("image")
                  // Log.i("zakaria ",img!!.url)
                 //   Log.i("zakaria ",item[i].userName)
                    item!!.add(parseTosimplerec(objs[i]))
                //    listOfLivre!!.add(item[i])
                   Log.i("userNames ",item[i].userName.toString())
                    val place = LatLng(item[i].Empoloyeelocation!!.latitude, item[i].Empoloyeelocation!!.longitude)
                    mMap.addMarker(MarkerOptions().position(place).title(item[i].userName).snippet("Number Phone "+item[i].phonenumber))
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(place))
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place,10f))
                    mMap.setOnMarkerClickListener(object :GoogleMap.OnMarkerClickListener{
                        override fun onMarkerClick(p0: Marker?): Boolean {
                                var view:View
                                view=layoutInflater.inflate(R.layout.info_ofworker,null)
                                view.editMaher.text=item[i].craft
                                view.editName.text=item[i].userName
                                view.phoneNumber.text=item[i].phonenumber.toString()
                               view.wilayaName.text=item[i].state.toString()
                       /*     Picasso.with(this@MapsOrderActivity)
                                .load(objs[i].getParseFile("image").url)
                                .into(imageEmployee)*/
                            showAlertDialog(view)

                       return true }

                    })
                }
            }else
            {
               // Log.e("bugs",e.message)
                Toast.makeText(this.baseContext,"no employee registre in the app from your state",Toast.LENGTH_LONG).show()

            }

        })




    }
    fun parseTosimplerec(puser:ParseObject):Employee{
        var user=Employee()
        user.objectId=puser.objectId
        user.userName=puser.getString("name")
        user.phonenumber=puser.getInt("phonenumber")
        user.craft=puser.getString("craft")
        user.Empoloyeelocation=puser.getParseGeoPoint("location")

        return user
    }



}









/*  override fun onMarkerClick(p0: Marker?): Boolean {
      var marker=p0!!.title
      var intent=intent
      var name = intent.getStringExtra(HomeViewModel.nameSer)
      if (marker!!.equals("Marker in Mascara")){
           Toast.makeText(this.applicationContext,"Marker Clicked",Toast.LENGTH_LONG).show()
          showAlertDialog(name,"Let's ReQuest this Factor")
      }
      return true
  }*/
