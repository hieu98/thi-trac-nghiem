package com.example.apptracnghiem.Model

import java.io.Serializable

data class DeThi (var id_de:String, var tenDe:String, var socauhoi:String, var thoigian: String,
                  var luotlam:String, var temmonhoc:String, var nguoirade:String, var ngayrade:String) :
    Serializable