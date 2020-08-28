package com.example.apptracnghiem

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.apptracnghiem.Adapater.CauhoiAdapater
import com.example.apptracnghiem.Model.CauHoi
import com.example.apptracnghiem.Model.DapAn
import com.example.apptracnghiem.Util.Global
import com.example.apptracnghiem.Util.Server
import kotlinx.android.synthetic.main.activity_lam_de.*
import org.json.JSONException
import org.json.JSONObject


class LamDeActivity : AppCompatActivity(){
    private lateinit var arrayListCauhoi:ArrayList<CauHoi>
    private lateinit var arrListDapan:ArrayList<DapAn>
    private var cauhoiAdapater : CauhoiAdapater?= null
    private lateinit var arrSelect:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lam_de)
        ActionBarCustom()
        var timer:Long
//        var select: List<String>
        val id = intent.getStringExtra("id")
        val time = intent.getIntExtra("thoigianlam", -1)
        val socauhoi = intent.getStringExtra("socauhoi")
        val thoigian = time.times(60000).toLong()
        val inten=Intent(this@LamDeActivity, ResultActivity::class.java)
        inten.putExtra("socauhoi", socauhoi)
        inten.putExtra("id", id)
        Log.v("thoigian", thoigian.toString())
        if (id != null) {
            Log.v("id_de", id)
        }
        if (id != null) {
            getQuestion(id)
        }
        arrSelect = ArrayList()
        arrayListCauhoi = ArrayList()
        arrListDapan = ArrayList()
        cauhoiAdapater = CauhoiAdapater(this, arrayListCauhoi,arrListDapan)
        list_cauhoi.adapter = cauhoiAdapater
        Log.v("size",arrListDapan.size.toString())


        object : CountDownTimer(thoigian, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                txtthoigian.text = String.format(
                    "%02d:%02d:%02d", (millisUntilFinished / 1000) / 3600,
                    ((millisUntilFinished / 1000) % 3600) / 60, ((millisUntilFinished / 1000) % 60)
                )
                btn_submit.setOnClickListener { cancel()
                    timer = ((millisUntilFinished / 1000) % 3600) / 60
                    for (i in 0 until arrListDapan.size){
                        arrSelect.add(arrListDapan[i].kq)
                        Log.v("kq $i",arrListDapan[i].kq)
                    }
                    Log.v("tham mo", timer.toString())
                    Log.v("arr", arrSelect.toString())
                    Log.v("arr dap an", arrListDapan.toString())
                    Log.v("kq 0",arrListDapan[0].kq)
                    inten.putExtra("thammo", timer.toInt())
                    inten.putExtra("select", arrSelect)
                    startActivity(inten)}
            }

            override fun onFinish() {
                txtthoigian.text = "Hết giờ"
                inten.putExtra("thammo", time)
//                click()
                Log.v("arr dap an", arrSelect.toString())
                inten.putExtra("select", arrSelect)
                startActivity(inten)
            }
        }.start()
    }

    fun getQuestion(id: String){
        val url = Server.cauHoide()+id+"/play"
        Log.v("url", url)
        val queue = Volley.newRequestQueue(this)
        val stringRequest = @RequiresApi(Build.VERSION_CODES.O)
        object: StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                val jsonObjects = JSONObject(response)
                val jsonObject1 = jsonObjects.getJSONObject("data")
                val jsonArray = jsonObject1.getJSONArray("questions")
                try {
                    Log.v("rp", response.toString())
                    Log.v("jsar", jsonArray.toString())
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val id_cau = jsonObject.getString("id")
                        val cauhoi = jsonObject.getString("question")
                        val A = jsonObject.getString("A")
                        val B = jsonObject.getString("B")
                        val C = jsonObject.getString("C")
                        var D = jsonObject.getString("D")
                        val E = ""
                        var F = jsonObject.getString("F")
                        Log.v("id", id_cau)
                        Log.v("cauhoi", cauhoi)
                        val causo: String = "Câu số " + (i + 1)
                        if (D == "null") {
                            D = ""
                        }
                        arrayListCauhoi.add(CauHoi(id_cau, causo, cauhoi, A, B, C, D))
                        arrListDapan.add(DapAn(A,B,C,D,E))
                        Log.v("arr hoi", arrayListCauhoi.toString())
                        Log.v("arr dap", arrListDapan.toString())
                        cauhoiAdapater?.notifyDataSetChanged()
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { })
        {
            override fun getHeaders(): MutableMap<String, String> {
            val headers = HashMap<String, String>()
            headers["Authorization"] = Global.token
            return headers
        }
        }

        queue.add(stringRequest)
    }

    private fun ActionBarCustom(){
        val title = intent.getStringExtra("tenDe")
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