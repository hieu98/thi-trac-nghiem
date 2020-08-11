package com.example.apptracnghiem.Data

import com.example.apptracnghiem.Model.Category

data class DataCategory(var message:String?, val data:Array<Category>){
    fun isSuccess():Boolean {
        return message =="success" }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DataCategory

        if (message != other.message) return false
        if (!data.contentEquals(other.data)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = message?.hashCode() ?: 0
        result = 31 * result + data.contentHashCode()
        return result
    }
}