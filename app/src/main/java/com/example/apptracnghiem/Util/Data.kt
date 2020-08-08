package com.example.apptracnghiem.Util

import com.example.apptracnghiem.Model.User

data class LogInRaw(val username:String,val password:String)

//response
data class LogInResponse(val status:Int?,val msg:String?,val data:User?){
    companion object {
        const val SUCCESS:Int= 200
    }
    fun isSuccess():Boolean=(status==SUCCESS)
}