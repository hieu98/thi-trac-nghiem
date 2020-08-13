package com.example.apptracnghiem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import butterknife.ButterKnife
import com.example.apptracnghiem.Model.User
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_header.*


class MainActivity : AppCompatActivity() {
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


}