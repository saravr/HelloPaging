package com.example.hellopaging

fun main() {
    repeat(10) {
        println(LongRange(100, 1000).random())
    }
}