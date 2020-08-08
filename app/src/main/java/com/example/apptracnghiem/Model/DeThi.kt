package com.example.apptracnghiem.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DeThi (var tenDe:String, var socauhoi:String, var thoigian: String, var luotlam:String, var temmonhoc:String, var nguoirade:String, var ngayrade:String) :
    Parcelable