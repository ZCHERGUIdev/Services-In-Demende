package com.zakariachergui.Services

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.location.LocationManager
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.zakariachergui.Services.Fragments.SignInActivityFragment
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var frg1=SignInActivityFragment()
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        setContentView(R.layout.activity_splash)

        if (NetworkisConnected())
        {
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Handler().postDelayed({
                supportFragmentManager.beginTransaction().replace(R.id.spashContainer,frg1).commit()
            },3000)
        }else{
                showAlertDialog()
                Toast.makeText(this,"Try Again",Toast.LENGTH_LONG).show()
            }
           // Toast.makeText(this,"Please Check Your Network Connection",Toast.LENGTH_SHORT).show()
           // exitApp()
        }else{            Toast.makeText(this,"No Connection",Toast.LENGTH_LONG).show()

            finish()
            System.exit(0)
        }


    }

    private fun showAlertDialog() {
        AlertDialog.Builder(this)
            .setMessage("خاصية gps غير مفعلة أنتقل لصفحة الإعدادات لتفعيله ")
            .setPositiveButton("صفحة الإعدادات") { dialog: DialogInterface?, which: Int ->

                var callGPSSettingIntent=Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(callGPSSettingIntent)

            }
            .setIcon(android.R.drawable.ic_dialog_alert).show()
    }
    private fun NetworkisConnected():Boolean{
        var connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var networkinfo=connectivityManager.activeNetworkInfo
        return  networkinfo!=null&&networkinfo.isConnected
    }
    private fun exitApp()
    {
        finish()
        System.exit(0)
    }
}