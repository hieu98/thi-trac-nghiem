package com.example.apptracnghiem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.apptracnghiem.R
import kotlinx.android.synthetic.main.activity_truockhilam.*

class PlayQuestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_truockhilam)
        val id_de = intent.getStringExtra("id_de")
        val tenDe = intent.getStringExtra("tenDe")
        txtTendethi.text = tenDe
        val socauhoi = intent.getStringExtra("socauhoi")
        txtSocauhoi.text = socauhoi
        val thoigian  = intent.getStringExtra("thoigian")
        txtThoigianlam.text = thoigian
        txtSoluotlamde.text = intent.getStringExtra("luotlam")
        txtMonhoc.text = intent.getStringExtra("temmonhoc")
        txtNguoirade.text = intent.getStringExtra("nguoirade")
        txtNgaydangde.text = intent.getStringExtra("ngayrade")
        ActionBarCustom()
        if (id_de != null) {
            Log.v("id_playquest", id_de)
        }
        btn_clicktoplay.setOnClickListener {
            val intent = Intent(this, LamDeActivity::class.java)
            intent.putExtra("id",id_de)
            intent.putExtra("tenDe",tenDe)
            intent.putExtra("socauhoi",socauhoi)
            if (thoigian != null) {
                intent.putExtra("thoigianlam",thoigian.toInt())
            }
            startActivity(intent)
        }
    }
    private fun ActionBarCustom(){
        val title = "Chuẩn bị làm bài"
        supportActionBar?.title =title
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }
}