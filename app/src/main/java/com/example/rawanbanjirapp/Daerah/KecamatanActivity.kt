package com.example.rawanbanjirapp.Daerah

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rawanbanjirapp.Daerah.Adapter.KecamatanAdapter
import com.example.rawanbanjirapp.Daerah.Model.Kecamatan
import com.example.rawanbanjirapp.UtilsApi.ApiClient
import com.example.rawanbanjirapp.databinding.ActivityKecamatanBinding
import com.google.gson.Gson
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KecamatanActivity : AppCompatActivity() {
    private lateinit var binding : ActivityKecamatanBinding
    private lateinit var context: Context

    lateinit var adapter : KecamatanAdapter
    lateinit var dataBean :List<Kecamatan.DATABean>
    //list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKecamatanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        getDataKecamatan()

    }

    private fun show(){
        binding.layoutIsiKecamatan.visibility = View.VISIBLE
        binding.loading.visibility = View.GONE
    }
    private fun load(){
        binding.layoutIsiKecamatan.visibility = View.GONE
        binding.loading.visibility = View.VISIBLE
    }
    private fun done(){
        binding.layoutIsiKecamatan.visibility = View.GONE
        binding.loading.visibility = View.GONE
    }

    private fun getDataKecamatan() {
        load()
        ApiClient.getClient.getKecamatan().enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful){
                    show()
                    val jsonO = JSONObject(response.body()!!.string())
                    if (jsonO.getString("status") == "200"){
                        val jsonA = jsonO.getJSONArray("DATA")

                        val gson = Gson()
                        dataBean = ArrayList()

                        for (i in 0 until jsonA.length()){
                            val kecamatanBean : Kecamatan.DATABean = gson.fromJson(jsonA.getJSONObject(i).toString(), Kecamatan.DATABean::class.java)
                            (dataBean as ArrayList<Kecamatan.DATABean>).add(kecamatanBean)
                        }

                        adapter = KecamatanAdapter(context,dataBean)
                        binding.recyclerKecamatan.adapter = adapter
                        binding.recyclerKecamatan.layoutManager = LinearLayoutManager(context)
                        binding.recyclerKecamatan.setHasFixedSize(true)

                    }else{
                        done()
                        Toast.makeText(context, jsonO.getString("status"), Toast.LENGTH_SHORT).show()
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

    fun backKecamatan(view: View) {
        finish()
    }
}
