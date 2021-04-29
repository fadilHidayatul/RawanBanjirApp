package com.example.rawanbanjirapp.UtilsApi

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @GET("daerah/get_kecamatan.php")
    fun getKecamatan(
        //empty
    ) : Call<ResponseBody>

    @GET("daerah/get_kelurahan.php")
    fun getKelurahan(
        @Query("id_kecamatan") id_kecamatan : String
    ) : Call<ResponseBody>

    @FormUrlEncoded
    @POST("daerah/get_daerah.php")
    fun getDaerah(
        @Field("id_kecamatan") id_kecamatan: String,
        @Field("id_kelurahan") id_kelurahan : String
    ) : Call<ResponseBody>

    @GET("informasi/get_informasi.php")
    fun getInformasi(
    ) : Call<ResponseBody>

    @FormUrlEncoded
    @POST("informasi/get_informasi_from_map.php")
    fun getInformasiFromMap(
        @Field("id_kelurahan") id_kelurahan: String
    ) : Call<ResponseBody>

    @GET("daerah/get_all_map.php")
    fun getAllMapData() : Call<ResponseBody>
}