package com.example.rawanbanjirapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.rawanbanjirapp.About.AboutActivity
import com.example.rawanbanjirapp.Bantuan.BantuanActivity
import com.example.rawanbanjirapp.Daerah.KecamatanActivity
import com.example.rawanbanjirapp.Informasi.DetailInformasiActivity
import com.example.rawanbanjirapp.Informasi.InformasiActivity
import com.example.rawanbanjirapp.Peta.PetaActivity
import com.example.rawanbanjirapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var context : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        binding.menu1.setOnClickListener {
            startActivity(Intent(this, KecamatanActivity::class.java))
        }
        binding.menu2.setOnClickListener {
            startActivity(Intent(this, PetaActivity::class.java))
        }
        binding.menu3.setOnClickListener {
            startActivity(Intent(this, InformasiActivity::class.java))
        }
        binding.menu4.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
        binding.menu5.setOnClickListener {
            startActivity(Intent(this, BantuanActivity::class.java))
        }
        binding.menu6.setOnClickListener {
            finish()
        }
    }
}
