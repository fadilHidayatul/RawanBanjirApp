package com.example.rawanbanjirapp.Daerah.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.rawanbanjirapp.Daerah.DetailDaerahActivity
import com.example.rawanbanjirapp.Daerah.Model.Kelurahan
import com.example.rawanbanjirapp.databinding.RowKelurahanBinding

class KelurahanAdapter(
    var context: Context,
    databean: List<Kelurahan.DATABean>,
    idKecamatan: String
) : RecyclerView.Adapter<KelurahanAdapter.viewHolder>() {
    private var mContext: Context = context
    private var listKelurahan : List<Kelurahan.DATABean> = databean
    private var idKecamatan : String = idKecamatan

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KelurahanAdapter.viewHolder {
        val view = RowKelurahanBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: KelurahanAdapter.viewHolder, position: Int) {
        holder.binding.txtKelurahan.text = listKelurahan[position].nama_kelurahan
        holder.binding.selectKelurahan.setOnClickListener {
            var intent = Intent(mContext,DetailDaerahActivity::class.java)
            intent.putExtra("idkec", idKecamatan)
            intent.putExtra("idkel", listKelurahan[position].id_kelurahan)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listKelurahan.size
    }

    inner class viewHolder(val binding : RowKelurahanBinding) : RecyclerView.ViewHolder(binding.root){

    }


}