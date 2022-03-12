package com.example.hellopaging

data class TestResponse(
    val items: List<TestItem>,
    val next: String
)