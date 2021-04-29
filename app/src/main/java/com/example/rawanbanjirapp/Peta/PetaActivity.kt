package com.example.rawanbanjirapp.Peta

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.rawanbanjirapp.R
import com.example.rawanbanjirapp.UtilsApi.ApiClient
import com.example.rawanbanjirapp.databinding.ActivityPetaBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import es.dmoral.toasty.Toasty
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PetaActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPetaBinding
    private lateinit var context: Context

    private lateinit var gmaps : GoogleMap
    private lateinit var pos : LatLng
    private lateinit var cameraPos : CameraPosition
    private var marker = MarkerOptions()

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
        ApiClient.getClient.getAllMapData().enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful){
                    val jsonO = JSONObject(response.body()!!.string())
                    if (jsonO.getString("status") == "200"){
                        val jsonA = jsonO.getJSONArray("DATA")

                        //map
                        gmaps = googlemap!!
                        pos = LatLng(-0.948735,100.410169)
                        cameraPos = CameraPosition.Builder().target(pos).zoom(12F).build()
                        googlemap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPos))

                        //marker
                        for (i in 0 until jsonA.length()){
                            val data = jsonA.getJSONObject(i)

                            var kelurahan = data.getString("kelurahan")
                            var bahaya = data.getString("bahaya")
                            var lati = data.getString("lat")
                            var longi = data.getString("lgt")
                            var center = LatLng(lati.toDouble(),longi.toDouble())

                            setMarkerBanjir(bahaya,center,kelurahan)
                        }
                    }else{
                        Toasty.error(context, "Data tidak ada", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toasty.error(context, "Cek Koneksi Internet", Toast.LENGTH_SHORT).show()
            }

        })


    }

    private fun setMarkerBanjir(bahaya: String, center: LatLng, kelurahan: String) {
        var bitmap : Bitmap = BitmapFactory.decodeResource(resources, R.drawable.marker_red)
        var b : Bitmap = Bitmap.createScaledBitmap(bitmap,50,80,true)

        marker.position(center)
        marker.title(kelurahan)
        marker.icon(BitmapDescriptorFactory.fromBitmap(b))

        gmaps.addMarker(marker)
    }

    fun backPeta(view: View) {
        finish()


    }
}
