package com.example.rawanbanjirapp.Informasi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.rawanbanjirapp.databinding.ActivityDetailInformasiBinding
import es.dmoral.toasty.Toasty

class DetailInformasiActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailInformasiBinding
    private lateinit var context : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailInformasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        var intent = intent
        var judul = intent.getStringExtra("judul")
        var isi = intent.getStringExtra("isi")
        var foto = intent.getStringExtra("foto")

        Toasty.error(context, "$judul dan $foto", Toast.LENGTH_SHORT).show()


    }
}
