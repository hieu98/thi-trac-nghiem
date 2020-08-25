package com.example.apptracnghiem

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.apptracnghiem.Data.LogInResponse
import com.example.apptracnghiem.Model.CauHoi
import com.example.apptracnghiem.Model.DeThi
import com.example.apptracnghiem.R
import com.example.apptracnghiem.Util.Global
import com.example.apptracnghiem.Util.Server
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.acticity_result.*
import org.json.JSONException
import org.json.JSONObject

class ResultActivity : AppCompatActivity() {
    var ketqua:String="5"
    var time :Int =0
    var select:Array<String>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acticity_result)
        supportActionBar?.hide()
        val socauhoi = intent.getStringExtra("socauhoi")
        val id= intent.getStringExtra("id")
        select = intent.getStringArrayExtra("select")
        time = intent.getIntExtra("thammo",-1)
        btn_backmain.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        if (id != null) {
            getResult(id)
        }
        kq_lam.text = ketqua + "/" + socauhoi
    }
    fun getResult(id:String){
        val url = Server.cauHoide()+id+"/submit"
        Log.v("url", url)
        val queue = Volley.newRequestQueue(this)

        val stringRequestg = object : StringRequest(Request.Method.POST, url, Response.Listener { response ->
            val jsonObject = JSONObject(response)
            val jsonObject1 = jsonObject.getJSONObject("data")
            ketqua = jsonObject1.getString("point")
        }, Response.ErrorListener { error ->})
        {
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["time"] = time.toString()
                params["selected"] = select.toString()
                return params
            }
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Authorization"] = Global.token
                return headers
            }
        }
        queue.add(stringRequestg)
    }
}