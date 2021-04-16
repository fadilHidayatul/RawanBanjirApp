package com.example.rawanbanjirapp.Daerah.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rawanbanjirapp.Daerah.KelurahanActivity
import com.example.rawanbanjirapp.Daerah.Model.Kecamatan
import com.example.rawanbanjirapp.databinding.RowKecamatanBinding

class KecamatanAdapter(var context: Context, dataBean: List<Kecamatan.DATABean>) : RecyclerView.Adapter<KecamatanAdapter.viewHolder>() {

    private var mContext: Context = context
    private var listKecamatan : List<Kecamatan.DATABean> = dataBean

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = RowKecamatanBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.binding.txtKecamatan.text = listKecamatan[position].nama_kecamatan
        holder.binding.selectKecamatan.setOnClickListener {
            val intent = Intent(context, KelurahanActivity::class.java)
            intent.putExtra("id_kecamatan", listKecamatan[position].id_kecamatan)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listKecamatan.size
    }

    inner class viewHolder(val binding : RowKecamatanBinding) : RecyclerView.ViewHolder(binding.root) {

    }


}