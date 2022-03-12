package com.example.hellopaging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class TestRepository {

    fun getItems(page: String?): Flow<PagingData<TestItem>> {
        return Pager(
            config = PagingConfig(pageSize = MockServer.PAGE_SIZE),
            pagingSourceFactory = { TestPagingSource(page) }
        ).flow
    }
}