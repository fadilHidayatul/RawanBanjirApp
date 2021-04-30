package com.example.rawanbanjirapp.UtilsApi

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
//    var BASE_URL : String = "http://192.168.100.35/banjirapp/"
//    var image : String = "http://192.168.100.35/banjirapp/foto/"

    var BASE_URL : String = "http://banjir.citragroup-hrd.com/public/api/"
    var image : String = "http://banjir.citragroup-hrd.com/public/assets/images/informasi/"

    val getClient : ApiInterface
        get() {
            val gson = GsonBuilder().setLenient().create()
            val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
}