package com.example.rawanbanjirapp.Bantuan.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rawanbanjirapp.Bantuan.Model.Bantuan
import com.example.rawanbanjirapp.databinding.RowBantuanBinding

class BantuanAdapter(var context: Context, val list: ArrayList<Bantuan>) : RecyclerView.Adapter<BantuanAdapter.ViewHolder>() {

    private var mContext : Context = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BantuanAdapter.ViewHolder {
        val view = RowBantuanBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BantuanAdapter.ViewHolder, position: Int) {
        val help = list[position]
        holder.binding.no.text = (position+1).toString()
        holder.binding.txtBantuan.text = help.txtBantuan
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(val binding : RowBantuanBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}