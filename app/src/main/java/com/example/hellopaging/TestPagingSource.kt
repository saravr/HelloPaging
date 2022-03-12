package com.example.hellopaging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import java.lang.Exception

class TestPagingSource(private val initial: String?): PagingSource<String, TestItem>() {
    private val mockServer = MockServer()

    override fun getRefreshKey(state: PagingState<String, TestItem>): String? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey ?: anchorPage?.nextKey
        }
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, TestItem> {
        val page = params.key ?: initial

        return try {
            val response = mockServer.get(page)
            val items = response.items
            val nextKey = response.next.ifEmpty { null }
            LoadResult.Page(items, null, nextKey)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}