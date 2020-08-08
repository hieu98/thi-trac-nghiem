package com.example.apptracnghiem.Util

object Server {
    val url = "https://thionline.tk"

    fun logIn():String= url.plus("/api/login")
}