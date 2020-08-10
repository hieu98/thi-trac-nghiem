package com.example.apptracnghiem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.drawerlayout.widget.DrawerLayout
import com.example.apptracnghiem.Model.User
import com.example.apptracnghiem.Presenter.LogInPresenter
import com.example.apptracnghiem.R
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private lateinit var drawer : DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDataUser()
    }

    fun getDataUser(){
        val bundle : Bundle? = intent.extras
        val user : User? = bundle?.getSerializable("USER") as User?
        if (user != null) {
            val token :String= user.token
            val email :String =user.email
            val username :String = user.username
            Log.v("token", token)
            Log.v("email", email)
            Log.v("name", username)
        }
    }
}