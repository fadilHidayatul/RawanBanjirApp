package com.example.rawanbanjirapp.Daerah

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rawanbanjirapp.Daerah.Adapter.KelurahanAdapter
import com.example.rawanbanjirapp.databinding.ActivityKelurahanBinding

class KelurahanActivity : AppCompatActivity() {
    private lateinit var binding : ActivityKelurahanBinding
    private lateinit var context : Context

    private lateinit var adapter : KelurahanAdapter
    //list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKelurahanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        getDataKelurahan()

    }

    private fun getDataKelurahan() {
        adapter = KelurahanAdapter(context)
        binding.recyclerKelurahan.adapter = adapter
        binding.recyclerKelurahan.layoutManager = LinearLayoutManager(context)
        binding.recyclerKelurahan.setHasFixedSize(true)
    }

    fun backKelurahan(view: View) {
        finish()
    }
}
