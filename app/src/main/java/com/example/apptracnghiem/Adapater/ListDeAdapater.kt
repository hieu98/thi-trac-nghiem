package com.example.apptracnghiem.Adapater

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.apptracnghiem.Model.DeThi
import com.example.apptracnghiem.R

class ListDeAdapater(var context:Context, var arrayListDe: ArrayList<DeThi>) : BaseAdapter() {

    override fun getItem(p0: Int): Any {
        return arrayListDe.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return arrayListDe.size
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val listItem:DeThi = arrayListDe.get(p0)
        val view =View.inflate(context, R.layout.item_danhsachde,null)
        val tenDe : TextView = view.findViewById(R.id.txtTendethi)
        tenDe.text = listItem.tenDe
        val socauhoi : TextView = view.findViewById(R.id.txtSocauhoi)
        socauhoi.text = listItem.socauhoi
        val thoigian : TextView = view.findViewById(R.id.txtThoigianlam)
        thoigian.text = listItem.thoigian
        val luotlam : TextView = view.findViewById(R.id.txtSoluotlamde)
        luotlam.text = listItem.luotlam
        val temmonhoc : TextView = view.findViewById(R.id.txtMonhoc)
        temmonhoc.text = listItem.temmonhoc
        val nguoirade : TextView = view.findViewById(R.id.txtNguoirade)
        nguoirade.text = listItem.nguoirade
        val ngayrade : TextView = view.findViewById(R.id.txtNgaydangde)
        ngayrade.text = listItem.ngayrade
        return view
    }
}