package com.zakariachergui.Services.Fragments

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.parse.ParseUser
import com.zakariachergui.Services.MainActivity
import com.zakariachergui.Services.Model.User
import com.zakariachergui.Services.R
import com.zakariachergui.Services.SplashActivity
import com.zakariachergui.Services.dao.UserDao
import kotlinx.android.synthetic.main.account_fragment.*
import kotlinx.android.synthetic.main.toolbar.*
import org.w3c.dom.Text

class AccountFragment : Fragment() {
    companion object {
        fun newInstance() = AccountFragment()
    }
    var userdao: UserDao? = null

    private lateinit var viewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.account_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userdao = UserDao()
        toolText.text="Account"
      //edtFirstName.hint= ParseUser.getCurrentUser().username
        btnSaveProFile.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                if (edtFirstName.text!=null && edtEmail.text!=null)
                {
                    ParseUser.getCurrentUser().username=edtFirstName.text.toString()
                    ParseUser.getCurrentUser().email=edtEmail.text.toString()
                    ParseUser.getCurrentUser().saveInBackground()
                    Toast.makeText(this@AccountFragment.context,"Saved",
                        Toast.LENGTH_LONG).show()
                    btnSaveProFile.isEnabled=false

                }else{
                    Toast.makeText(this@AccountFragment.context,"Input data to your field",
                        Toast.LENGTH_LONG).show()
                }

            }

        })
        logOut.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                ParseUser.logOut()
                startActivity(Intent(this@AccountFragment.context,SplashActivity::class.java))
            }

        })
    }

}