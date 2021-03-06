package com.example.apptracnghiem.Util

import android.content.Context

object Injection {
    private lateinit var context: Context

    fun setUp(mContext: Context){
        context= mContext
    }

    fun provideLogInRepository(context: Context):LoginRepository{
       return LoginRepository.getInstance(context)
    }
}