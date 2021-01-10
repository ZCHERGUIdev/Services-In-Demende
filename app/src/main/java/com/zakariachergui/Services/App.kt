package com.zakariachergui.Services

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.parse.*

class App : Application() {
    override fun onCreate() {
       super.onCreate()
        Parse.enableLocalDatastore(this)
         Parse.initialize(
             Parse.Configuration.Builder(this)
                 .applicationId("Oy5nEA5tIVEsnMl9xOLvPPperBT5VzlZIa7s2nfs")
                 .clientKey("eFLkEYLpCpOzIxPudUpAiboBPcYHZF8JO9Oz4DsG")
                 .server("https://parseapi.back4app.com")
                 .build()
         //eFLkEYLpCpOzIxPudUpAiboBPcYHZF8JO9Oz4DsG
         )
        var parceAcl=ParseACL()
        parceAcl.publicReadAccess=true
        parceAcl.publicWriteAccess=true
        ParseACL.setDefaultACL(parceAcl,true)


    }
}