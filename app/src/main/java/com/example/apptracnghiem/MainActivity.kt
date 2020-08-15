package com.example.apptracnghiem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.apptracnghiem.Adapater.CategoryAdapater
import com.example.apptracnghiem.Model.Category
import com.example.apptracnghiem.Model.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_header.*

class MainActivity : AppCompatActivity(),AdapterView.OnItemClickListener {

    private var arrayList:ArrayList<Category> ?=null
    private var cateAdapater :CategoryAdapater ?= null
    private var username :String = ""
    private var email :String=""
    private var token :String =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDataUser()
        btn_nav.setOnClickListener {
            drawer.openDrawer(GravityCompat.START)
            txtUsername.text = username
            txtEmail.text = email
        }
        closeDrawer()
        arrayList = setCategory()
        cateAdapater = CategoryAdapater(this, arrayList!!)
        grid_view.adapter = cateAdapater
        grid_view.onItemClickListener =this



    }

    fun setCategory():ArrayList<Category>{
        val arrayList : ArrayList<Category> = ArrayList()
        arrayList.add(Category(1,"Đại học"))
        arrayList.add(Category(2,"THCS & THPT"))
        arrayList.add(Category(3,"Lập trình"))
        arrayList.add(Category(4,"Chuyên môn"))
        arrayList.add(Category(5,"Tiếng Anh"))
        arrayList.add(Category(6,"Ngôn ngữ khác"))
        arrayList.add(Category(7,"Kiến thức xã hội"))
        return arrayList
    }

    private fun closeDrawer(){
        drawer.closeDrawer(GravityCompat.START)
        nav_view.setNavigationItemSelectedListener { item: MenuItem ->
            when(item.itemId){
                R.id.nav_dedalam->{

                }
                R.id.nav_dedaluu->{

                }
            }
            return@setNavigationItemSelectedListener true
        }
    }

    private fun getDataUser(){
        val bundle : Bundle? = intent.extras
        val user : User? = bundle?.getSerializable("USER") as User?
        if (user != null) {
            token = user.token
            email  =user.email
            username  = user.username
            Log.v("token", token)
            Log.v("email", email)
            Log.v("name", username)
        }
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val item:Category = arrayList!![p2]
        Toast.makeText(this,item.tenCategory,Toast.LENGTH_LONG).show()
        val intent = Intent(this, ListDeActivity::class.java)
        intent.putExtra("id",item.id)
        startActivity(intent)
    }

}