package com.example.hellopaging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.hellopaging.databinding.ItemTestBinding

class TestAdapter: PagingDataAdapter<TestItem, TestViewHolder>(DiffCallback()) {

    class DiffCallback: DiffUtil.ItemCallback<TestItem>() {
        override fun areItemsTheSame(oldItem: TestItem, newItem: TestItem) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: TestItem, newItem: TestItem) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TestViewHolder(ItemTestBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}