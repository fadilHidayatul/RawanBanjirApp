package com.example.rawanbanjirapp.Daerah

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.rawanbanjirapp.Informasi.DetailInformasiActivity
import com.example.rawanbanjirapp.R
import com.example.rawanbanjirapp.UtilsApi.ApiClient
import com.example.rawanbanjirapp.databinding.ActivityDetailDaerahBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.*
import es.dmoral.toasty.Toasty
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailDaerahActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailDaerahBinding
    private lateinit var context: Context

    private var idkec : String = ""
    private var idkel : String = ""

    private lateinit var gmaps : GoogleMap
    private lateinit var cameraPos : CameraPosition
    private lateinit var center : LatLng
    private var marker = MarkerOptions()
    private var circle = CircleOptions()

    private lateinit var pos : LatLng

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDaerahBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        var intent = intent
        idkec = intent.getStringExtra("idkec")!!
        idkel = intent.getStringExtra("idkel")!!

        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.onResume()
        AsyncMapView()

    }

    private fun show(){
        binding.layoutIsi.visibility = View.VISIBLE
        binding.loading.visibility = View.GONE
    }
    private fun load(){
        binding.layoutIsi.visibility = View.GONE
        binding.loading.visibility = View.VISIBLE
    }

    private fun AsyncMapView() {
        binding.mapView.getMapAsync(object :OnMapReadyCallback{
            override fun onMapReady(googlemap: GoogleMap?) {
                getDataDaerah(idkec,idkel,googlemap)
            }

        })
    }
    private fun getDataDaerah(idkec: String, idkel: String, googlemap: GoogleMap?) {
        load()
        ApiClient.getClient.getDaerah(idkec,idkel).enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful){
                    show()
                    val jsonO = JSONObject(response.body()!!.string())
                    if (jsonO.getString("status") == "200"){
                        val jsonA = jsonO.getJSONArray("DATA")
                        val data = jsonA.getJSONObject(0)

                        //text
                        val kecamatan = data.getString("nama_kecamatan")
                        val kelurahan = data.getString("nama_kelurahan")
                        val range = data.getString("luas")
                        val kode = data.getString("kode_bahaya")
                        val risk = data.getString("tingkat_bahaya")

                        binding.keckel.text = "Kecamatan $kecamatan, Kelurahan $kelurahan"
                        binding.range.text = "Radius bahaya $range m"
                        binding.risk.text = risk

                        //map
                        pos = LatLng(data.getString("lat").toDouble(),data.getString("lgt").toDouble())
                        gmaps = googlemap!!
                        cameraPos = CameraPosition.Builder().target(pos).zoom(17F).build()
                        googlemap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPos))

                        //marker
                        setMarker(pos,kode,range,kelurahan)

                    }else{
                        Toast.makeText(context,"${jsonO.getString("message")}", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(context,"Respon Failure", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(context,"Cek Koneksi Internet", Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun setMarker(pos: LatLng, kode: String, range: String, kelurahan: String) {
        var bitmap : Bitmap = BitmapFactory.decodeResource(resources, R.drawable.lottie_loading)
        var b : Bitmap = Bitmap.createScaledBitmap(bitmap,100,100,true)

        marker.position(pos)
        marker.title("test")
//        marker.icon(BitmapDescriptorFactory.fromBitmap(b))

        circle.center(pos)
        circle.radius(range.toDouble())
        circle.strokeColor(R.color.blue)
        circle.strokeWidth(0.5F)
        circle.fillColor(R.color.dark_blue)

        gmaps.addMarker(marker)
        gmaps.addCircle(circle)
        gmaps.setOnMarkerClickListener(object : GoogleMap.OnMarkerClickListener{
            override fun onMarkerClick(p0: Marker?): Boolean {
                Toasty.success(context, "$kelurahan", Toast.LENGTH_SHORT,false).show()
                return true
            }
        })

    }
    fun backDetailDaerah(view: View) {
        finish()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    fun detailInformasi(view: View) {
        var intent = Intent(this,DetailInformasiActivity::class.java)
        intent.putExtra("idkelurahan",idkel)
        startActivity(intent)
    }
}
