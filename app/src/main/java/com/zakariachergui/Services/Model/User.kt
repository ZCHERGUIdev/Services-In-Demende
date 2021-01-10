package com.zakariachergui.Services.Model

import android.location.Location

class User {
    //poko class
    var userName: String? =null
    var paswword: String? =null
    var userEmail: String? =null
    var objectId: String? =null

constructor(){


}

    constructor(name: String?, pass: String?, email: String?,o:String?) {
        this.userName = name
        this.paswword = pass
        this.userEmail = email
        this.objectId=o
    }
    constructor(name: String?, pass: String?, email: String?) {
        this.userName = name
        this.paswword = pass
        this.userEmail = email
    }
    constructor(name: String?, email: String?) {
        this.userName = name
        this.userEmail = email

    }

}