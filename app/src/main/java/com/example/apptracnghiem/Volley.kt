package com.example.apptracnghiem

import android.app.Application
import android.util.Log
import com.android.volley.VolleyLog
import com.example.apptracnghiem.Util.Injection

class Volley : Application() {
    override fun onCreate() {
        super.onCreate()
        Injection.setUp(this)
        VolleyLog.setTag("Volley")
        Log.isLoggable("Volley",Log.VERBOSE)
    }
}