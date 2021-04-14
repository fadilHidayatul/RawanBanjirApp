package com.example.rawanbanjirapp.Daerah

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rawanbanjirapp.Daerah.Adapter.KecamatanAdapter
import com.example.rawanbanjirapp.databinding.ActivityKecamatanBinding

class KecamatanActivity : AppCompatActivity() {
    private lateinit var binding : ActivityKecamatanBinding
    private lateinit var context: Context

    lateinit var adapter : KecamatanAdapter
    //list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKecamatanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        getDataKecamatan()

    }

    private fun getDataKecamatan() {
        adapter = KecamatanAdapter(context)
        binding.recyclerKecamatan.adapter = adapter
        binding.recyclerKecamatan.layoutManager = LinearLayoutManager(context)
        binding.recyclerKecamatan.setHasFixedSize(true)
    }

    fun backKecamatan(view: View) {
        finish()
    }
}
