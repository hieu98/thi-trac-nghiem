package com.example.apptracnghiem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apptracnghiem.R
import kotlinx.android.synthetic.main.acticity_result.*

class ResultActivity : AppCompatActivity() {
    val ketqua:String="5"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acticity_result)
        supportActionBar?.hide()
        val socauhoi = intent.getStringExtra("socauhoi")

        btn_backmain.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        kq_lam.text = ketqua + "/" + socauhoi
    }
    fun getResult(){

    }
}