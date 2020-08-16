package com.example.apptracnghiem

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.apptracnghiem.Adapater.ListDeAdapater
import com.example.apptracnghiem.Model.DeThi
import kotlinx.android.synthetic.main.activity_listde.*

class ListDeActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private var arrayListDe:ArrayList<DeThi> ?=null
    private var DeAdapater : ListDeAdapater?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listde)
        arrayListDe = ArrayList()
        DeAdapater = ListDeAdapater(this,arrayListDe!!)
        list_de.adapter = DeAdapater
        list_de.onItemClickListener=this
        ActionBarCustom()
    }

    private fun ActionBarCustom(){
        val title = intent.getStringExtra("name")
        supportActionBar?.title =title
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
    }

    fun getListDeCategory(){

    }

    fun getListDedaluu(){

    }
    fun getListDedalam(){

    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val item: DeThi = arrayListDe!![p2]
        val intent = Intent(this, PlayQuestActivity::class.java)
        intent.putExtra("tenDe",item.tenDe)
        intent.putExtra("luotlam",item.luotlam)
        intent.putExtra("ngayrade",item.ngayrade)
        intent.putExtra("socauhoi",item.socauhoi)
        intent.putExtra("temmonhoc",item.temmonhoc)
        intent.putExtra("thoigian",item.thoigian)
        intent.putExtra("nguoirade",item.nguoirade)
        startActivity(intent)
    }
}