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

    private var chkIntent : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailInformasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        val intent = intent
        chkIntent = intent.getBooleanExtra("chk",false)
        val judul = intent.getStringExtra("judul")
        val isi = intent.getStringExtra("isi")
        val foto = intent.getStringExtra("foto")

        val idkelurahan = intent.getStringExtra("idkelurahan")

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
        binding.lNotFound.visibility = View.GONE
    }
    private fun load(){
        binding.lInformasiIsi.visibility = View.GONE
        binding.loading.visibility = View.VISIBLE
        binding.lNotFound.visibility = View.GONE
    }
    private fun done(){
        binding.lInformasiIsi.visibility = View.GONE
        binding.loading.visibility = View.GONE
        binding.lNotFound.visibility = View.VISIBLE
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
                        binding.txtNotFound.text = "Data Tidak Ada!!"
                    }
                }else{
                    done()
                    binding.txtNotFound.text = "Error Response"
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                done()
                binding.txtNotFound.text = "Koneksi Internet"
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

    fun backMap(view: View) {
        finish()
    }
}
