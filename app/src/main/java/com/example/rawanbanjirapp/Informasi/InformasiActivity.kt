package com.example.rawanbanjirapp.Informasi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rawanbanjirapp.Informasi.Adapter.InformasiAdapter
import com.example.rawanbanjirapp.Informasi.Model.Informasi
import com.example.rawanbanjirapp.UtilsApi.ApiClient
import com.example.rawanbanjirapp.databinding.ActivityInformasiBinding
import com.google.gson.Gson
import es.dmoral.toasty.Toasty
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InformasiActivity : AppCompatActivity() {
    private lateinit var binding : ActivityInformasiBinding
    private lateinit var context: Context

    private lateinit var adapter : InformasiAdapter
    private lateinit var dataBean : List<Informasi.DATABean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        getInformasi()

    }

    private fun getInformasi() {
       ApiClient.getClient.getInformasi().enqueue(object : Callback<ResponseBody>{
           override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
               if (response.isSuccessful){
                   val jsonO = JSONObject(response.body()!!.string())
                   if (jsonO.getString("status") == "200"){
                       val jsonA = jsonO.getJSONArray("DATA")

                       val gson = Gson()
                       dataBean = ArrayList()

                       for (i in 0 until jsonA.length()){
                            val modelInformasi : Informasi.DATABean = gson.fromJson(jsonA.getJSONObject(i).toString(), Informasi.DATABean::class.java)
                           (dataBean as ArrayList<Informasi.DATABean>).add(modelInformasi)
                       }

                       adapter = InformasiAdapter(context, dataBean)
                       binding.recyclerKecamatan.adapter = adapter
                       binding.recyclerKecamatan.layoutManager = LinearLayoutManager(context)
                       binding.recyclerKecamatan.setHasFixedSize(true)

                   }
               }
           }

           override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
               Toasty.error(context, "Cek Koneksi Internet", Toast.LENGTH_SHORT).show();
           }

       })
    }

    fun backInformasi(view: View) {
        finish()
    }
}
