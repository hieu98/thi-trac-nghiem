package com.example.apptracnghiem.Adapater

import android.content.Context
import android.graphics.Color
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.apptracnghiem.Model.CauHoi
import com.example.apptracnghiem.Model.DeThi
import com.example.apptracnghiem.R
import kotlinx.android.synthetic.main.item_cauhoi.view.*

class CauhoiAdapater(var context: Context, var arrayListCauhoi: ArrayList<CauHoi>): BaseAdapter() {

    override fun getItem(p0: Int): Any {
        return arrayListCauhoi[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return arrayListCauhoi.size
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val listItem: CauHoi = arrayListCauhoi[p0]
        var select:String =""
        val view:View = View.inflate(context, R.layout.item_cauhoi,null)
        val cauhoi : TextView = view.findViewById(R.id.txtCauhoi)
        cauhoi.text = Html.fromHtml(listItem.cauhoi)
        val causo : TextView = view.findViewById(R.id.txtCauso)
        causo.text = listItem.causo
        val A : TextView = view.findViewById(R.id.txtDapanA)
        A.text = Html.fromHtml(listItem.A)
//        view.ln1.setOnClickListener {
//            select="A"
//        }
        val B : TextView = view.findViewById(R.id.txtDapanB)
        B.text = Html.fromHtml(listItem.B)
//        view.ln2.setOnClickListener {
//
//            select="B"
//
//        }
        val C : TextView = view.findViewById(R.id.txtDapanC)
        C.text = Html.fromHtml(listItem.C)
//        view.ln3.setOnClickListener {
//
//            select="C"
//        }
        val D : TextView = view.findViewById(R.id.txtDapanD)
        D.text = Html.fromHtml(listItem.D)
//        view.ln4.setOnClickListener {
//            select="D"
//        }
//        when (select) {
//            "A" -> {
//                view.A.setBackgroundResource(R.drawable.background_question_red)
//                view.D.setBackgroundResource(R.drawable.tags_background)
//                view.B.setBackgroundResource(R.drawable.tags_background)
//                view.C.setBackgroundResource(R.drawable.tags_background)
//            }
//            "B" -> {
//                view.A.setBackgroundResource(R.drawable.tags_background)
//                view.B.setBackgroundResource(R.drawable.background_question_red)
//                view.C.setBackgroundResource(R.drawable.tags_background)
//                view.D.setBackgroundResource(R.drawable.tags_background)
//            }
//            "C" -> {
//                view.A.setBackgroundResource(R.drawable.tags_background)
//                view.B.setBackgroundResource(R.drawable.tags_background)
//                view.C.setBackgroundResource(R.drawable.background_question_red)
//                view.D.setBackgroundResource(R.drawable.tags_background)
//            }
//            "D" -> {
//                view.D.setBackgroundResource(R.drawable.background_question_red)
//                view.A.setBackgroundResource(R.drawable.tags_background)
//                view.B.setBackgroundResource(R.drawable.tags_background)
//                view.C.setBackgroundResource(R.drawable.tags_background)
//            }
//        }
        return view

    }
}