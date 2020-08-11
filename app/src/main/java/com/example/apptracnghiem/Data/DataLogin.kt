package com.example.apptracnghiem.Data

import com.example.apptracnghiem.Model.User

data class LogInRaw(val email:String,val password:String)

//response
data class LogInResponse(var message:String?, val data:User){
    fun isSuccess():Boolean {
       return message =="success" }
}