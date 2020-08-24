package com.example.apptracnghiem.Adapater

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.apptracnghiem.Model.CauHoi
import com.example.apptracnghiem.Model.DeThi
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
        val listItem: CauHoi = arrayListCauhoi[p0]
//        var click=0
        val view:View = View.inflate(context, R.layout.item_cauhoi,null)
        val cauhoi : TextView = view.findViewById(R.id.txtCauhoi)
        cauhoi.text = listItem.cauhoi
        val causo : TextView = view.findViewById(R.id.txtCauso)
        causo.text = listItem.causo
        val A : TextView = view.findViewById(R.id.txtDapanA)
        A.text = listItem.A
//        A.setOnClickListener { click=1 }
//        A.setOnClickListener { A.setBackgroundColor(Color.RED) }
        val B : TextView = view.findViewById(R.id.txtDapanB)
        B.text = listItem.B
//        B.setOnClickListener { click=2 }
        val C : TextView = view.findViewById(R.id.txtDapanC)
        C.text = listItem.C
//        C.setOnClickListener { click=3 }
        val D : TextView = view.findViewById(R.id.txtDapanD)
        D.text = listItem.D
//        D.setOnClickListener { click=4 }
//        when(click){
//            1->A.setBackgroundColor(Color.RED)
//            2->B.setBackgroundColor(Color.RED)
//            3->C.setBackgroundColor(Color.RED)
//            4->C.setBackgroundColor(Color.RED)
//        }

        return view
    }
}