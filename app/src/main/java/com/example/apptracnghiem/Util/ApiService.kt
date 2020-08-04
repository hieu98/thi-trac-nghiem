package com.example.apptracnghiem.Util

import com.example.apptracnghiem.Model.DeModel
import com.example.apptracnghiem.Model.UserModel
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

object ApiService {
    const val URL = "https://example.com/api/"

    val service: AppRepository by lazy {
        val logging = HttpLoggingInterceptor()
        val gson = GsonBuilder().serializeNulls().setPrettyPrinting().create()
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //(*)
            .client(client)
            .build().create<AppRepository>(AppRepository::class.java)
    }

    interface AppRepository {
        @FormUrlEncoded
        @POST("user")
        fun auth(@Field("username") username: String, @Field("password") password: String): Observable<UserModel>

        @GET("dethi")
        fun getCategory(): Observable<DeModel>
    }
}