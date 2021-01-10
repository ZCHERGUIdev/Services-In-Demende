package com.zakariachergui.Services.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.zakariachergui.Services.MainActivity
import com.zakariachergui.Services.Model.User
import com.zakariachergui.Services.R
import com.zakariachergui.Services.dao.UserDao
import kotlinx.android.synthetic.main.activity_sign_in_fragment.*

class SignInActivityFragment : Fragment() {

    companion object {
        fun newInstance() = SignInActivityFragment()
    }

    var userdao: UserDao? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_sign_in_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         userdao = UserDao()


        sign_IN.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var user = User(
                    edtUserName.text.toString(),
                    edtPassword.text.toString(),
                    "zcbilarabi@gmail.com",
                    ""
                )
                logInwithcalback(user)
            }

        })
        SignUpp.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                fragmentManager!!.beginTransaction().replace(R.id.signincontent,SignUpActivityFragment()).commit()
            }

        })


    }

     fun logInwithcalback(user:User) {
        userdao!!.LogInWithCalback(user, { reternedUser ->
            if (reternedUser.userName != null) {
                var intent = Intent(
                    this@SignInActivityFragment.context,
                    MainActivity::class.java
                )
                var budle = Bundle()
                budle.putString("userName", reternedUser.userName)
                intent.putExtras(budle)
                startActivity(intent)

            }else{
                Toast.makeText(this@SignInActivityFragment.context,"You are not register",Toast.LENGTH_LONG).show()
            }

        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userdao = UserDao()
        if (userdao!!.checkLoggin())
        {
            var intent = Intent(
                this@SignInActivityFragment.context,
                MainActivity::class.java
            )
            startActivity(intent)
        }

    }
}