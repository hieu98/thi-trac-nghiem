package com.example.apptracnghiem.Util

import com.example.apptracnghiem.Model.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RestApi {
    @Headers("Content-Type: application/json")
    @POST("user")
    fun checkUser(@Body userData: UserModel): Call<UserModel>

}