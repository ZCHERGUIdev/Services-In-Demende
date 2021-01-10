package com.zakariachergui.Services.Model

import android.location.Location
import com.google.android.gms.maps.model.LatLng
import com.parse.ParseGeoPoint

class Employee{
    var userName: String? =null
    var phonenumber: Int? =null
    var image: Int? =null
    var craft: String? =null
    var state: String? =null
    var Empoloyeelocation:ParseGeoPoint?=null
    var objectId: String? =null
    constructor(){

    }
    constructor(name: String?,pn:Int,img:Int ,craft: String?, state: String?,o:String?,clat:Double,clong:Double){
        this.userName=name
        this.phonenumber=pn
        this.image=img
        this.craft=craft
        this.state=state
        this.objectId=o
        this.Empoloyeelocation=ParseGeoPoint(clat,clong)
    }

}