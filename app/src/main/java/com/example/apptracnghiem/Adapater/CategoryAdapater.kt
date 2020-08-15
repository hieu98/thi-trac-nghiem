package com.example.apptracnghiem.Adapater

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.apptracnghiem.Model.Category
import com.example.apptracnghiem.R

class CategoryAdapater(var context: Context, var arrayList: ArrayList<Category>): BaseAdapter() {
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view:View = View.inflate(context, R.layout.item_category,null)
        val name :TextView = view.findViewById(R.id.name)
        val listItem:Category = arrayList.get(p0)
        name.text = listItem.tenCategory
        return view
    }

    override fun getItem(p0: Int): Any {
        return arrayList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }
}