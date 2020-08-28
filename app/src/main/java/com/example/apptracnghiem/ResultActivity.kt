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
    var select: List<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acticity_result)
        supportActionBar?.hide()
        val socauhoi = intent.getStringExtra("socauhoi")
        val id= intent.getStringExtra("id")
        select = intent.getStringArrayListExtra("select")!!
        Log.v("slect",select.toString())

        time = intent.getIntExtra("thammo",-1)
        Log.v("time",time.toString())

        btn_backmain.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        if (id != null) {
            if (socauhoi != null) {
                getResult(id,socauhoi)
            }
        }
        Log.v("glb sl",Global.select.toString())
    }
    fun getResult(id:String,socauhoi:String){
        val url = Server.cauHoide()+id+"/submit"
        Log.v("url", url)
        val queue = Volley.newRequestQueue(this)
        val stringRequestg = object : StringRequest(Request.Method.POST, url, Response.Listener { response ->
            val jsonObject = JSONObject(response)
            val jsonObject1 = jsonObject.getJSONObject("data")
            ketqua = jsonObject1.getString("point")
            kq_lam.text = ketqua + "/" + socauhoi
        }, Response.ErrorListener { error ->})
        {
            override fun getBodyContentType(): String {
                return "application/json"
            }

            @Throws(AuthFailureError::class)
            override fun getBody(): ByteArray {
                val params2 = HashMap<String, Int>()
                params2.put("time",time)
                val param3= HashMap<String,List<String>>()
                select?.let { param3.put("selected", it) }
                Log.v("param",JSONObject(params2+param3).toString())
                return JSONObject(param3+params2).toString().toByteArray()
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