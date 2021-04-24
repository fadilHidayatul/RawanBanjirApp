package com.example.rawanbanjirapp.Informasi.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rawanbanjirapp.Informasi.DetailInformasiActivity
import com.example.rawanbanjirapp.Informasi.Model.Informasi
import com.example.rawanbanjirapp.UtilsApi.ApiClient
import com.example.rawanbanjirapp.databinding.RowInformasiBinding

class InformasiAdapter(context: Context, dataBean: List<Informasi.DATABean>) : RecyclerView.Adapter<InformasiAdapter.viewHolder>() {

    private var mContext : Context = context
    private var mList : List<Informasi.DATABean> = dataBean


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformasiAdapter.viewHolder {
        val view = RowInformasiBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: InformasiAdapter.viewHolder, position: Int) {
        var data = mList[position]

        var tgl = data.tgl.substring(8,10)
        var bln = data.tgl.substring(5,7)
        var thn = data.tgl.substring(0,4)

        holder.binding.judulInformasi.text = data.judul
        holder.binding.tglInformasi.text = "$tgl-$bln-$thn"
        Glide.with(mContext)
            .load(ApiClient.image+data.foto)
            .centerCrop()
            .into(holder.binding.imgInformasi)

        holder.binding.cardInformasi.setOnClickListener{
            var intent = Intent(mContext,DetailInformasiActivity::class.java)
            intent.putExtra("chk", true)
            intent.putExtra("judul", data.judul)
            intent.putExtra("isi", data.isi)
            intent.putExtra("foto", data.foto)
            mContext.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class viewHolder(val binding : RowInformasiBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}