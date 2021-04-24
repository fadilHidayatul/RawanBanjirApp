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

//        Toasty.error(context, "$judul dan $foto", Toast.LENGTH_SHORT).show()

        if (isIntentIn()){
            getDataFromIntent(judul,isi,foto)
        }else{
            Toasty.error(context, "API", Toast.LENGTH_SHORT).show()
        }

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
