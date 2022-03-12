package com.example.hellopaging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import java.lang.Exception

class TestPagingSource(private val page: Int): PagingSource<Int, TestItem>() {
    private val mockServer = MockServer()

    override fun getRefreshKey(state: PagingState<Int, TestItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TestItem> {
        val pageNumber = params.key ?: page

        return try {
            val items = mockServer.get(pageNumber)
            LoadResult.Page(items, null, pageNumber + 1)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}