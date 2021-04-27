package com.example.rawanbanjirapp.Peta

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rawanbanjirapp.databinding.ActivityPetaBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class PetaActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPetaBinding
    private lateinit var context: Context

    private lateinit var gmaps : GoogleMap
    private lateinit var pos : LatLng
    private lateinit var cameraPos : CameraPosition

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPetaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.onResume()
        AsyncMapView()
    }

    private fun AsyncMapView() {
        binding.mapView.getMapAsync(object : OnMapReadyCallback{
            override fun onMapReady(googlemap: GoogleMap?) {
                getAllMapData(googlemap)
            }

        })
    }

    private fun getAllMapData(googlemap: GoogleMap?) {
        gmaps = googlemap!!
        pos = LatLng(-0.954670,100.357187)
        cameraPos = CameraPosition.Builder().target(pos).zoom(12F).build()
        googlemap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPos))

    }

    fun backPeta(view: View) {
        finish()
    }
}
