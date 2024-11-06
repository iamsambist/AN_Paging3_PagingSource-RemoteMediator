package com.sunaa.paginationstimulation.repo

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sunaa.paginationstimulation.remote.FakeRepository
import com.sunaa.paginationstimulation.remote.ListItem
import kotlinx.coroutines.delay

class ItemPagingSource(
    private val repository: FakeRepository,
    private val pageSize: Int = 20
) : PagingSource<Int, ListItem>() {

    override fun getRefreshKey(state: PagingState<Int, ListItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListItem> {
        val page = params.key ?: 0
        delay(2000L)
        return try {
            val response = repository.getItems(page, pageSize).getOrDefault(emptyList())
            LoadResult.Page(
                data = response,
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (response.isNotEmpty()) page + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}