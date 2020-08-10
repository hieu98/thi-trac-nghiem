package com.example.apptracnghiem.Util

object Server {
    val url = "https://thionline.tk"

    fun logIn():String= url.plus("/api/login/")
    fun signUp() :String = url.plus("/api/signup")
    fun categoRy():String = url.plus("/api/category")
}