package com.example.apptracnghiem.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserModel(
    @SerializedName("username") val username: String?,
    @SerializedName("useremail") val email: String?,
    @SerializedName("userpassword") val password: String?) :
    Parcelable