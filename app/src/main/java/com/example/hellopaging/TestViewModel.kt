package com.example.hellopaging

import androidx.lifecycle.ViewModel

class TestViewModel: ViewModel() {
    private val mockServer = MockServer()

    fun getItems(page: Int): List<TestItem> {
        return mockServer.get(page)
    }
}