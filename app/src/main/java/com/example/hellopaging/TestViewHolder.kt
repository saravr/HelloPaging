package com.example.hellopaging

import androidx.recyclerview.widget.RecyclerView
import com.example.hellopaging.databinding.ItemTestBinding

class TestViewHolder(private val binding: ItemTestBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TestItem) {
        binding.tvName.text = item.name
    }
}