package com.example.hellopaging

import kotlinx.coroutines.delay

class MockServer {
    private val seed: Int
        get() {
            return (System.currentTimeMillis() % 100).toInt()
        }

    suspend fun get(next: String?): TestResponse {
        val items = next?.let {
            it.split(",").map { item ->
                val id = item.trim().toIntOrNull() ?: 0
                val rand = LongRange(1000000, 5000000).random()
                TestItem(id, "Item $id - $rand")
            }
        } ?: Array(PAGE_SIZE) {
            val id = it + 1
            val rand = LongRange(1000000, 5000000).random()
            TestItem(id, "Item $id - $rand")
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
        const val PAGE_SIZE = 10
        private const val LIMIT = 1000
    }
}