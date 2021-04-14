package com.example.rawanbanjirapp.Informasi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rawanbanjirapp.Informasi.Adapter.InformasiAdapter
import com.example.rawanbanjirapp.databinding.ActivityInformasiBinding

class InformasiActivity : AppCompatActivity() {
    private lateinit var binding : ActivityInformasiBinding
    private lateinit var context: Context

    private lateinit var adapter : InformasiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        getInformasi()

    }

    private fun getInformasi() {
        adapter = InformasiAdapter(context)
        binding.recyclerKecamatan.adapter = adapter
        binding.recyclerKecamatan.layoutManager = LinearLayoutManager(context)
        binding.recyclerKecamatan.setHasFixedSize(true)
    }

    fun backInformasi(view: View) {
        finish()
    }
}
