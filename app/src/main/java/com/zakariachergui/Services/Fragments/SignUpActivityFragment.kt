package com.zakariachergui.Services.Fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
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
import kotlinx.android.synthetic.main.activity_sign_up_fragment.*

class SignUpActivityFragment : Fragment() {
    companion object {
        fun newInstance() = SignUpActivityFragment()
    }

    var userdao: UserDao? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_sign_up_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        userdao = UserDao()
        signnIN.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                fragmentManager!!.beginTransaction()
                    .replace(R.id.signupcontent, SignInActivityFragment()).commit()
            }

        })
        //sign Up
        btnSignUp.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var user = User(
                    edtUsername.text.toString(),
                    edtPass.text.toString(),
                    edtEmail.text.toString()
                )

                    userdao?.SignUpWithCalback(user, { reternedUser ->
                        if (reternedUser.userName != null) {
                            logInwithcalback(reternedUser)
                            Toast.makeText(
                                this@SignUpActivityFragment.context, "done",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            Toast.makeText(
                                this@SignUpActivityFragment.context, "somthingwrong",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    })
                }
        })
    }

    fun logInwithcalback(user: User) {
        userdao!!.LogInWithCalback(user, { reternedUser ->
            if (reternedUser.userName != null) {
                var intent = Intent(
                    this@SignUpActivityFragment.context,
                    MainActivity::class.java
                )
                var budle = Bundle()
                budle.putString("userName", reternedUser.userName)
                intent.putExtras(budle)
                startActivity(intent)

            } else {
                Toast.makeText(
                    this@SignUpActivityFragment.context,
                    "You are not register",
                    Toast.LENGTH_LONG
                ).show()
            }

        })
    }
}