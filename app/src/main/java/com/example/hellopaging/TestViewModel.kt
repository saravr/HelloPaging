package com.example.hellopaging

import androidx.lifecycle.ViewModel

class TestViewModel: ViewModel() {
    private val repository = TestRepository()

    fun getItems(page: Int): List<TestItem> {
        return repository.getItems(page)
    }
}