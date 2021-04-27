package com.example.rawanbanjirapp.Informasi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.rawanbanjirapp.UtilsApi.ApiClient
import com.example.rawanbanjirapp.databinding.ActivityDetailInformasiBinding
import es.dmoral.toasty.Toasty
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailInformasiActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailInformasiBinding
    private lateinit var context : Context

    var chkIntent : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailInformasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        var intent = intent
        chkIntent = intent.getBooleanExtra("chk",false)
        var judul = intent.getStringExtra("judul")
        var isi = intent.getStringExtra("isi")
        var foto = intent.getStringExtra("foto")

        var idkelurahan = intent.getStringExtra("idkelurahan")

//        Toasty.error(context, "$judul dan $foto", Toast.LENGTH_SHORT).show()

        if (isIntentIn()){
            getDataFromIntent(judul,isi,foto)
        }else{
            getInformasiFromMap(idkelurahan)
        }

    }

    private fun show(){
        binding.lInformasiIsi.visibility = View.VISIBLE
        binding.loading.visibility = View.GONE
    }
    private fun load(){
        binding.lInformasiIsi.visibility = View.GONE
        binding.loading.visibility = View.VISIBLE
    }
    private fun done(){
        binding.lInformasiIsi.visibility = View.GONE
        binding.loading.visibility = View.GONE
    }

    private fun getInformasiFromMap(idkelurahan: String?) {
        load()
        ApiClient.getClient.getInformasiFromMap(idkelurahan.toString()).enqueue(object :Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful){
                    val jsonO = JSONObject(response.body()!!.string())
                    if (jsonO.getString("status") == "200"){
                        show()
                        val jsonA = jsonO.getJSONArray("DATA")
                        val data = jsonA.getJSONObject(0)

                        binding.judulInformasi.text = data.getString("judul")
                        binding.isiInformasi.text = data.getString("isi")
                        Glide.with(context)
                            .load(ApiClient.image+data.getString("foto"))
                            .centerCrop()
                            .into(binding.imgInformasiDetail)
                    }else{
                        done()
                        Toasty.error(context, "Data tidak ada", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    done()
                    Toasty.error(context, "Error Response", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                done()
                Toasty.error(context, "Koneksi Internet", Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun getDataFromIntent(judul: String?, isi: String?, foto: String?) {
        binding.judulInformasi.text = judul
        binding.isiInformasi.text = isi
        Glide.with(context)
            .load(ApiClient.image+foto)
            .centerCrop()
            .into(binding.imgInformasiDetail)
    }

    fun isIntentIn() : Boolean {
        return chkIntent
    }
}
