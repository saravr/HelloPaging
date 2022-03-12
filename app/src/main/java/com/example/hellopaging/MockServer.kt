package com.example.hellopaging

import kotlinx.coroutines.delay

class MockServer {

    suspend fun get(next: String?): TestResponse {
        val items = next?.let {
            it.split(",").map { item ->
                val id = item.trim().toIntOrNull() ?: 0
                TestItem(id, "Item $id")
            }
        } ?: Array(PAGE_SIZE) {
            val id = it + 1
            TestItem(id, "Item $id")
        }.toList()

        val nextIds = if (items.last().id <= (LIMIT - PAGE_SIZE)) {
            items.map { it.id + PAGE_SIZE }.joinToString()
        } else {
            ""
        }

        delay(LongRange(100, 800).random())
        return TestResponse(items, nextIds)
    }

    companion object {
        const val PAGE_SIZE = 40
        private const val LIMIT = 500
    }
}