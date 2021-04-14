package com.example.rawanbanjirapp.Informasi.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.rawanbanjirapp.Informasi.DetailInformasiActivity
import com.example.rawanbanjirapp.databinding.RowInformasiBinding

class InformasiAdapter(context: Context) : RecyclerView.Adapter<InformasiAdapter.viewHolder>() {

    private var mContext : Context = context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformasiAdapter.viewHolder {
        val view = RowInformasiBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: InformasiAdapter.viewHolder, position: Int) {
        holder.binding.judulInformasi.text = "Contoh Informasi"

        holder.binding.cardInformasi.setOnClickListener{
            Toast.makeText(mContext,"card ke : $position", Toast.LENGTH_SHORT).show()
            var intent = Intent(mContext,DetailInformasiActivity::class.java)
            mContext.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return 5
    }

    class viewHolder(val binding : RowInformasiBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}