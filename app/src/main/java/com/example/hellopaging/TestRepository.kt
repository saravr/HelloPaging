package com.example.hellopaging

class TestRepository {
    private val mockServer = MockServer()

    fun getItems(page: Int): List<TestItem> {
        return mockServer.get(page)
    }
}