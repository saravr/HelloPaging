package com.example.hellopaging

class MockServer {

    fun get(next: String?): TestResponse {
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

        return TestResponse(items, nextIds)
    }

    companion object {
        const val PAGE_SIZE = 10
        private const val LIMIT = 50
    }
}