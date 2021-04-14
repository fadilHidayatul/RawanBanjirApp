package com.example.rawanbanjirapp.Daerah.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.rawanbanjirapp.databinding.RowKecamatanBinding
import com.example.rawanbanjirapp.databinding.RowKelurahanBinding

class KelurahanAdapter(var context: Context) : RecyclerView.Adapter<KelurahanAdapter.viewHolder>() {
    private var mContext: Context = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KelurahanAdapter.viewHolder {
        val view = RowKelurahanBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: KelurahanAdapter.viewHolder, position: Int) {
        holder.binding.txtKelurahan.text = "Muara Panas"
        holder.binding.selectKelurahan.setOnClickListener {
            Toast.makeText(context,"Selamat",Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return 7
    }

    inner class viewHolder(val binding : RowKelurahanBinding) : RecyclerView.ViewHolder(binding.root){

    }


}