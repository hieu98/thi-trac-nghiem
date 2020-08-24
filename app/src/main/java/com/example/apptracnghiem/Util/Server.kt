package com.example.apptracnghiem.Util

object Server {
    val url = "https://thionline.tk"

    fun logIn():String= url.plus("/api/login/")
    fun signUp() :String = url.plus("/api/signup")
    fun deCategory():String= url.plus("/api/student/tests?category=")
    fun deDaluu():String=url.plus("/api/student/tests/saved")
    fun deDalam():String=url.plus("/api/student/tests/history")
    fun cauHoide():String=url.plus("/api/student/test/")
}