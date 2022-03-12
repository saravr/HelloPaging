package com.example.hellopaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.hellopaging.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val testViewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TestAdapter()
        binding.recyclerView.adapter = adapter

        val items = testViewModel.getItems(0)
        adapter.submitList(items)
    }
}