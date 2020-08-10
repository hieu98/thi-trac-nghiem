package com.example.apptracnghiem.Util

import com.example.apptracnghiem.Model.User

data class LogInRaw(val email:String,val password:String)

//response
data class LogInResponse(var message:String?, val data:User){
    companion object {
        const val SUCCESS:Int= 200
    }
    fun isSuccess():Boolean {
       return message =="success" }
}