package com.example.rawanbanjirapp.Bantuan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rawanbanjirapp.databinding.ActivityBantuanBinding

class BantuanActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBantuanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBantuanBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
