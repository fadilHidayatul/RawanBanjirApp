package com.example.rawanbanjirapp.Informasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rawanbanjirapp.databinding.ActivityDetailInformasiBinding

class DetailInformasiActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailInformasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailInformasiBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
