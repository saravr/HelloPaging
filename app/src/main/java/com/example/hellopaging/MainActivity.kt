package com.example.hellopaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.hellopaging.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val testViewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TestAdapter()
        binding.recyclerView.adapter = adapter

        binding.srLayout.setOnRefreshListener {
            adapter.refresh()
        }

        lifecycleScope.launch {
            testViewModel.getItems().collect {
                binding.srLayout.isRefreshing = false
                adapter.submitData(it)
            }
        }
    }
}