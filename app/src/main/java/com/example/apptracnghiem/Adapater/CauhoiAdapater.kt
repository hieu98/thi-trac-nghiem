package com.example.apptracnghiem.Adapater

import android.content.Context
import android.os.Build
import android.text.Html
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import com.example.apptracnghiem.Model.CauHoi
import com.example.apptracnghiem.Model.DapAn
import com.example.apptracnghiem.R


class CauhoiAdapater(var context: Context, var arrayListCauhoi: ArrayList<CauHoi>, var arrDapAn:ArrayList<DapAn>): BaseAdapter(){
    var select :Array<String>?=null

    override fun getItem(p0: Int): Any {
        return arrayListCauhoi[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return arrayListCauhoi.size
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val listItem: CauHoi = arrayListCauhoi[p0]
        var select:String =""
        val view:View = View.inflate(context, R.layout.item_cauhoi,null)
        val cauhoi : TextView = view.findViewById(R.id.txtCauhoi)
        cauhoi.text = Html.fromHtml(listItem.cauhoi)
        val causo : TextView = view.findViewById(R.id.txtCauso)
        causo.text = listItem.causo
        val A:TextView = view.findViewById(R.id.txtDapanA)
        A.text= Html.fromHtml(listItem.A)
        val B:TextView = view.findViewById(R.id.txtDapanB)
        B.text= Html.fromHtml(listItem.B)
        val C:TextView = view.findViewById(R.id.txtDapanC)
        C.text= Html.fromHtml(listItem.C)
        val D:TextView = view.findViewById(R.id.txtDapanD)
        D.text= Html.fromHtml(listItem.D)
        val ln1 :LinearLayout= view.findViewById(R.id.ln1)
        val ln2 :LinearLayout= view.findViewById(R.id.ln2)
        val ln3 :LinearLayout= view.findViewById(R.id.ln3)
        val ln4 :LinearLayout= view.findViewById(R.id.ln4)
        val tvA :TextView= view.findViewById(R.id.A)
        val tvB :TextView= view.findViewById(R.id.B)
        val tvC :TextView= view.findViewById(R.id.C)
        val tvD :TextView= view.findViewById(R.id.D)
        ln1.setOnClickListener {
            arrDapAn[p0].kq="A"
            tvA.setBackgroundResource(R.drawable.background_question_red)
            tvB.setBackgroundResource(R.drawable.tags_background)
            tvC.setBackgroundResource(R.drawable.tags_background)
            tvD.setBackgroundResource(R.drawable.tags_background)
        }
        ln2.setOnClickListener {
            arrDapAn[p0].kq="B"
            tvB.setBackgroundResource(R.drawable.background_question_red)
            tvA.setBackgroundResource(R.drawable.tags_background)
            tvC.setBackgroundResource(R.drawable.tags_background)
            tvD.setBackgroundResource(R.drawable.tags_background)
        }
        ln3.setOnClickListener {
            arrDapAn[p0].kq="C"
            tvC.setBackgroundResource(R.drawable.background_question_red)
            tvB.setBackgroundResource(R.drawable.tags_background)
            tvA.setBackgroundResource(R.drawable.tags_background)
            tvD.setBackgroundResource(R.drawable.tags_background)
        }
        ln4.setOnClickListener {
            arrDapAn[p0].kq="D"

        }

        when(arrDapAn[p0].kq){
            "A"->{
                tvA.setBackgroundResource(R.drawable.background_question_red)
                tvB.setBackgroundResource(R.drawable.tags_background)
                tvC.setBackgroundResource(R.drawable.tags_background)
                tvD.setBackgroundResource(R.drawable.tags_background)
            }
            "B"->{
                tvB.setBackgroundResource(R.drawable.background_question_red)
                tvA.setBackgroundResource(R.drawable.tags_background)
                tvC.setBackgroundResource(R.drawable.tags_background)
                tvD.setBackgroundResource(R.drawable.tags_background)
            }
            "C"->{
                tvC.setBackgroundResource(R.drawable.background_question_red)
                tvB.setBackgroundResource(R.drawable.tags_background)
                tvA.setBackgroundResource(R.drawable.tags_background)
                tvD.setBackgroundResource(R.drawable.tags_background)
            }
            "D"->{
                tvD.setBackgroundResource(R.drawable.background_question_red)
                tvB.setBackgroundResource(R.drawable.tags_background)
                tvC.setBackgroundResource(R.drawable.tags_background)
                tvA.setBackgroundResource(R.drawable.tags_background)
            }
        }
        Log.v("dap an $p0",arrDapAn[p0].kq)
        return view
    }
}