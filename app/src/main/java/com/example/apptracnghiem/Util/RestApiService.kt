package com.example.apptracnghiem.Util

import com.example.apptracnghiem.Model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RestApiService {
    fun checkUser(userData : UserModel, onResult: (UserModel?)->Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.checkUser(userData).enqueue(
            object : Callback<UserModel> {
                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<UserModel>, response: Response<UserModel>) {
                    val checkedUser = response.body()
                    onResult(checkedUser)
                }
            }
        )
    }
}