package com.zakariachergui.Services.dao

import android.text.Editable
import android.util.Log
import android.widget.Toast
import com.parse.*
import com.zakariachergui.Services.Fragments.SignInActivityFragment
import com.zakariachergui.Services.Fragments.SignUpActivityFragment
import com.zakariachergui.Services.Model.User

class UserDao {
    var parseUser:ParseUser?=null

   constructor(){
       parseUser= ParseUser()
   }
// signUp === newaccount
    //signIn==registre
    //signOut==
    //update==
    fun SignUp() {
      parseUser?.setPassword("123456")
      parseUser?.username="zakaria02"
      parseUser?.email="zakariachergui@gmail.com"
    parseUser?.signUpInBackground(object :SignUpCallback{
        override fun done(e: ParseException?) {
            if (e==null)
            {//done
               Log.i("user","it's done")
            }else
            {
                Log.i("user","somthing wrong")

            }

        }
    })

   }

    fun LogIn(user:User){
        ParseUser.logInInBackground(user.userName,user.paswword,
            {puser,e ->
                if (puser!=null)
                {  Log.i("user","done")
                }
                else{
                    Log.i("user","Failed") }
            })
    }
    fun parseTosimplerec(puser:ParseUser,pass:String):User{
        var user=User()
        user.objectId=puser.objectId
        user.userName=puser.username
        user.paswword=pass
        return user
    }

    fun LogInWithCalback(user: User, calback:(reternedUser:User)->Unit) {
        ParseUser.logInInBackground(user.userName,user.paswword,
            {puser,e ->
                if (puser!=null)
                { calback(parseTosimplerec(puser,user.paswword.toString()))
                    Log.i("User","done")
                }
                else{
                    calback(User())
                    Log.i("User","You Are Not Register ") }
            })
    }

    fun SignUpWithCalback(user: User,calback:(reternedUser:User)->Unit) {
        parseUser?.username=user.userName
        parseUser?.setPassword(user.paswword)
        parseUser?.email=user.userEmail

            parseUser?.signUpInBackground(object :SignUpCallback{
                override fun done(e: ParseException?) {
                    if (e==null)
                    {//done
                        calback(user)
                        Log.i("user","it's done")
                    }else {
                        calback(User())
                        Log.i("user","somthing wrong")

                    }

                }
            })
        }
    fun checkLoggin():Boolean{
           if (ParseUser.getCurrentUser()!=null)
           {
              return true
           }else{
               return false
           }
        return false
     }





}