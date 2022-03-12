package com.example.hellopaging

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class TestViewModel: ViewModel() {
    private val repository = TestRepository()

    fun getItems(page: String? = null): Flow<PagingData<TestItem>> {
        return repository.getItems(page)
    }
}