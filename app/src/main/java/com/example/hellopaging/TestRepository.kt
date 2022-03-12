package com.example.hellopaging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class TestRepository {
    private val mockServer = MockServer()

    fun getItems(page: Int): Flow<PagingData<TestItem>> {
        return Pager(
            config = PagingConfig(pageSize = MockServer.PAGE_SIZE),
            pagingSourceFactory = { TestPagingSource(page) }
        ).flow
    }

    fun getItemsOld(page: Int): List<TestItem> {
        return mockServer.get(page)
    }
}