package com.example.rawanbanjirapp.Bantuan

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rawanbanjirapp.Bantuan.Adapter.BantuanAdapter
import com.example.rawanbanjirapp.Bantuan.Model.Bantuan
import com.example.rawanbanjirapp.Bantuan.Model.ObjectBantuan
import com.example.rawanbanjirapp.databinding.ActivityBantuanBinding

class BantuanActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBantuanBinding
    private lateinit var context : Context

    private lateinit var adapter : BantuanAdapter
    private var list : ArrayList<Bantuan> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBantuanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        list.addAll(ObjectBantuan.listHelp)

        getHelp()
    }

    private fun getHelp() {
        adapter = BantuanAdapter(context,list)
        binding.recyclerBantuan.adapter = adapter
        binding.recyclerBantuan.layoutManager = LinearLayoutManager(context)
        binding.recyclerBantuan.setHasFixedSize(true)
    }

    fun backBantuan(view: View) {
        finish()
    }
}
