package com.example.apptracnghiem.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserModel(var username: String,var email: String, var password: String, var phone:String ) :
    Parcelable