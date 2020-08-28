package com.example.apptracnghiem.Util

import android.app.Application

public class Global : Application() {
    companion object {
        @JvmField
        var token: String = ""
        var username:String =""
        var email:String=""
        var select: Array<String>? = null
    }
}