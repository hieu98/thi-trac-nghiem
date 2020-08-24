package com.example.apptracnghiem

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.annotation.RequiresApi
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.apptracnghiem.Adapater.CauhoiAdapater
import com.example.apptracnghiem.Model.CauHoi
import com.example.apptracnghiem.Util.Global
import com.example.apptracnghiem.Util.Server
import kotlinx.android.synthetic.main.activity_lam_de.*
import org.json.JSONException
import org.json.JSONObject

class LamDeActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private lateinit var arrayListCauhoi:ArrayList<CauHoi>
    private var cauhoiAdapater : CauhoiAdapater?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lam_de)
        ActionBarCustom()
        val id= intent.getStringExtra("id")
        if (id != null) {
            Log.v("id_de",id)
        }
        if (id != null) {
            getQuestion(id)
        }
        arrayListCauhoi = ArrayList()
        cauhoiAdapater = CauhoiAdapater(this,arrayListCauhoi)
        list_cauhoi.adapter = cauhoiAdapater
        list_cauhoi.onItemClickListener=this

    }

    fun getQuestion(id:String){
        val url = Server.cauHoide()+id+"/play"
        Log.v("url",url)
        val queue = Volley.newRequestQueue(this)
        val stringRequest = @RequiresApi(Build.VERSION_CODES.O)
        object: StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                val jsonObjects = JSONObject(response)
                val jsonObject1= jsonObjects.getJSONObject("data")
                val jsonArray = jsonObject1.getJSONArray("questions")
                try {
                    Log.v("rp",response.toString())
                    Log.v("jsar",jsonArray.toString())
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val id_cau = jsonObject.getString("id")
                        val cauhoi = jsonObject.getString("question")
                        val A = jsonObject.getString("A")
                        val B = jsonObject.getString("B")
                        val C = jsonObject.getString("C")
                        var D = jsonObject.getString("D")
                        val E = jsonObject.getString("E")
                        var F = jsonObject.getString("F")
                        Log.v("id",id_cau)
                        Log.v("cauhoi",cauhoi)
                        val causo :String = "Câu số "+(i+1)
                        if(D=="null"){D=""}
                        arrayListCauhoi.add(CauHoi(id_cau,causo,cauhoi,A,B,C,D))
                        Log.v("arr",arrayListCauhoi.toString())
                        cauhoiAdapater?.notifyDataSetChanged()
                    }
                }catch (e: JSONException){
                    e.printStackTrace()
                }
            },
            Response.ErrorListener {  })
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

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }
}