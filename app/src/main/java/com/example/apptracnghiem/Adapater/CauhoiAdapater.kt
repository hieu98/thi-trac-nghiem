package com.example.apptracnghiem.Adapater

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.apptracnghiem.Model.CauHoi
import com.example.apptracnghiem.R

class CauhoiAdapater(var context: Context, var arrayListCauhoi: ArrayList<CauHoi>): BaseAdapter() {

    override fun getItem(p0: Int): Any {
        return arrayListCauhoi.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return arrayListCauhoi.size
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view:View = View.inflate(context, R.layout.item_cauhoi,null)

        return view
    }
}