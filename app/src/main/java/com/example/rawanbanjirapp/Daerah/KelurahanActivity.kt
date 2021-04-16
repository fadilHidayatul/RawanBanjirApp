package com.example.rawanbanjirapp.Daerah

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rawanbanjirapp.Daerah.Adapter.KelurahanAdapter
import com.example.rawanbanjirapp.Daerah.Model.Kelurahan
import com.example.rawanbanjirapp.UtilsApi.ApiClient
import com.example.rawanbanjirapp.databinding.ActivityKelurahanBinding
import com.google.gson.Gson
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KelurahanActivity : AppCompatActivity() {
    private lateinit var binding : ActivityKelurahanBinding
    private lateinit var context : Context

    private var idKecamatan : String = ""
    private lateinit var adapter : KelurahanAdapter
    private lateinit var databean : List<Kelurahan.DATABean>
    //list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKelurahanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        var intent : Intent = intent
        idKecamatan = intent.getStringExtra("id_kecamatan")!!
//        Toast.makeText(context, "$idKecamatan", Toast.LENGTH_SHORT).show()

        getDataKelurahan(idKecamatan)
    }

    private fun show(){
        binding.layoutIsiKelurahan.visibility = View.VISIBLE
        binding.loading.visibility = View.GONE
    }
    private fun load(){
        binding.layoutIsiKelurahan.visibility = View.GONE
        binding.loading.visibility = View.VISIBLE
    }
    private fun done(){
        binding.layoutIsiKelurahan.visibility = View.GONE
        binding.loading.visibility = View.GONE
    }

    private fun getDataKelurahan(idKecamatan: String) {
        load()
        ApiClient.getClient.getKelurahan(idKecamatan).enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful){
                    val jsonO = JSONObject(response.body()!!.string())
                    if (jsonO.getString("status") == "200"){
                        show()
                        val jsonA = jsonO.getJSONArray("DATA")

                        databean = ArrayList()
                        val gson = Gson()

                        for (i in 0 until jsonA.length()){
                            val kelurahanDatabean : Kelurahan.DATABean = gson.fromJson(jsonA.getJSONObject(i).toString(), Kelurahan.DATABean::class.java)
                            (databean as ArrayList<Kelurahan.DATABean>).add(kelurahanDatabean)
                        }
                        adapter = KelurahanAdapter(context,databean, idKecamatan)
                        binding.recyclerKelurahan.adapter = adapter
                        binding.recyclerKelurahan.layoutManager = LinearLayoutManager(context)
                        binding.recyclerKelurahan.setHasFixedSize(true)

                    }else{
                        done()
                        Toast.makeText(context,jsonO.getString("message"), Toast.LENGTH_SHORT).show()
                    }
                }else{
                    done()
                    Toast.makeText(context,"Respon Failure", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                done()
                Toast.makeText(context,"Cek Koneksi Internet", Toast.LENGTH_SHORT).show()
            }

        })

    }

    fun backKelurahan(view: View) {
        finish()
    }
}
