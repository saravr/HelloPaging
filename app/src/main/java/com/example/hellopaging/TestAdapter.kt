package com.example.hellopaging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hellopaging.databinding.ItemTestBinding

class TestAdapter: ListAdapter<TestItem, TestViewHolder>(DiffCallback()) {

    class DiffCallback: DiffUtil.ItemCallback<TestItem>() {
        override fun areItemsTheSame(oldItem: TestItem, newItem: TestItem) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: TestItem, newItem: TestItem) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TestViewHolder(ItemTestBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class TestViewHolder(private val binding: ItemTestBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TestItem) {
        binding.tvName.text = item.name
    }
}

data class TestItem(
    val id: Int,
    val name: String
)