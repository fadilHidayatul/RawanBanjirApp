package com.example.rawanbanjirapp.Daerah

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.rawanbanjirapp.UtilsApi.ApiClient
import com.example.rawanbanjirapp.databinding.ActivityDetailDaerahBinding
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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDaerahBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        var intent = intent
        idkec = intent.getStringExtra("idkec")!!
        idkel = intent.getStringExtra("idkel")!!

        Toast.makeText(context,"$idkec & $idkel", Toast.LENGTH_SHORT).show()
        getDataDaerah(idkec,idkel)
    }

    private fun getDataDaerah(idkec: String, idkel: String) {
        ApiClient.getClient.getDaerah(idkec,idkel).enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful){
                    val jsonO = JSONObject(response.body()!!.string())
                    if (jsonO.getString("status") == "200"){
                        val jsonA = jsonO.getJSONArray("DATA")
                        val data = jsonA.getJSONObject(0)

                        val kecamatan = data.getString("nama_kecamatan")
                        val kelurahan = data.getString("nama_kelurahan")
                        val range = data.getString("luas")

                        binding.keckel.text = "Kecamatan $kecamatan, Kelurahan $kelurahan"
                        binding.range.text = "Radius $range m"

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
}
