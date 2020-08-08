package com.example.apptracnghiem.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CauHoi (var causo:String, var A:String, var B :String, var C:String, var D:String) :
    Parcelable