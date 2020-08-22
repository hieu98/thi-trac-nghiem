package com.example.apptracnghiem.Service

import com.example.apptracnghiem.Model.DeThi
import com.example.apptracnghiem.Util.Server
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIService {
    @GET("/api/student/tests")
    fun deCategory(@Query("category") id:String
    ): Call<List<DeThi>>
}