package com.example.hellopaging

class MockServer {

    fun get(page: Int): List<TestItem> {
        val items = Array(PAGE_SIZE) {
            val index = (page * PAGE_SIZE) + it
            TestItem(it, "Item $index")
        }.toMutableList()

        return items
    }

    companion object {
        const val PAGE_SIZE = 10
    }
}