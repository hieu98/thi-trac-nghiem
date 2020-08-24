package com.example.apptracnghiem

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.apptracnghiem.Adapater.ListDeAdapater
import com.example.apptracnghiem.Model.DeThi
import com.example.apptracnghiem.Util.Global
import com.example.apptracnghiem.Util.Server
import kotlinx.android.synthetic.main.activity_listde.*
import org.json.JSONException
import org.json.JSONObject
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.set

class ListDeActivity : AppCompatActivity(), AdapterView.OnItemClickListener{

    private lateinit var arrayListDe:ArrayList<DeThi>
    private var DeAdapater : ListDeAdapater?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listde)
        val id = intent.getIntExtra("id",-1).toString()
        Log.v("id",id)
        arrayListDe = ArrayList()
        DeAdapater = ListDeAdapater(this,arrayListDe)
        list_de.adapter = DeAdapater
        list_de.onItemClickListener=this
        ActionBarCustom()
        getListDeCategory(id)
    }

    private fun ActionBarCustom(){
        val title = intent.getStringExtra("name")
        supportActionBar?.title =title
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
    }


    fun getListDeCategory(id:String){
        val url = Server.deCategory()+id
        Log.v("url",url)
        val queue = Volley.newRequestQueue(this)
        val stringRequest = @RequiresApi(Build.VERSION_CODES.O)
        object: StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                val jsonObjects = JSONObject(response)
                val jsonObject1= jsonObjects.getJSONObject("data")
                val jsonArray = jsonObject1.getJSONArray("tests")
                try {
                    Log.v("rp",response.toString())
                    Log.v("jsar",jsonArray.toString())
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val id_de = jsonObject.getString("id")
                        val tenDe = jsonObject.getString("name")
                        val socauhoi = jsonObject.getString("question")
                        val thoigian = jsonObject.getString("time")
                        val luotlam = jsonObject.getString("access")
                        val temmonhoc = jsonObject.getString("tag")
                        val nguoirade = jsonObject.getString("parent")
                        var ngayrade = jsonObject.getString("created_at")
                        Log.v("id",id_de)
                        Log.v("nguoirade",nguoirade)

                        ngayrade = ngayrade.substring(0,10)
                        arrayListDe.add(DeThi(id_de,tenDe,socauhoi,thoigian,luotlam,temmonhoc,nguoirade,ngayrade))
                        Log.v("arr",arrayListDe.toString())
                        DeAdapater?.notifyDataSetChanged()
                    }
                }catch (e: JSONException){
                    e.printStackTrace()
                }
            },
            Response.ErrorListener {  })
        {
//            override fun getParams(): MutableMap<String, String> {
//                    params["category"] = id
//                    return params
//            }

            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Authorization"] = Global.token
                return headers
            }
        }

        queue.add(stringRequest)
    }

    fun getListDedaluu(){

    }
    fun getListDedalam(){

    }


    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val item: DeThi = arrayListDe!![p2]
        val intent = Intent(this, PlayQuestActivity::class.java)
        intent.putExtra("id_de",item.id_de)
        intent.putExtra("tenDe",item.tenDe)
        intent.putExtra("luotlam",item.luotlam)
        intent.putExtra("ngayrade",item.ngayrade)
        intent.putExtra("socauhoi",item.socauhoi)
        intent.putExtra("temmonhoc",item.temmonhoc)
        intent.putExtra("thoigian",item.thoigian)
        intent.putExtra("nguoirade",item.nguoirade)
        startActivity(intent)
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