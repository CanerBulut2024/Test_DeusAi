package com.deusai.test_deusai

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deusai.test_deusai.databinding.ItemTipBinding

class DynamicTipsAdapter(private val tipsList: List<String>) : RecyclerView.Adapter<DynamicTipsAdapter.TipViewHolder>() {

    // ViewHolder class
    inner class TipViewHolder(private val binding: ItemTipBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tip: String) {
            binding.tvTip.text = tip
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val binding = ItemTipBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tipsList[position]
        holder.bind(tip)
    }

    override fun getItemCount(): Int = tipsList.size
}
