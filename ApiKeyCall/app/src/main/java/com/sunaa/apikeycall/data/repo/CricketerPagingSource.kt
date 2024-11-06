package com.sunaa.apikeycall.data.repo

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sunaa.apikeycall.data.remote.Data
import retrofit2.HttpException

class CricketerPagingSource(
    private val apiService: CrickRepoImp
) : PagingSource<Int, Data>() {


    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        // Set your desired page size and maximum pages to load
        val pageSize = 25
        val maxPages = 4
        val pageIndex = params.key ?: 0
        return try {
            val response = apiService.getPlayers(page = pageIndex * pageSize)
            if (response.isSuccessful) {
                val players =
                    response.body()?.data ?: emptyList() // Assuming body() returns ApiResponse
                val nextkey = if(pageIndex < maxPages ) pageIndex + 1 else null
                Log.i("loaded","Loaded page with key ${pageIndex}")
                LoadResult.Page(
                    data = players,
                    prevKey = if (pageIndex == 0) null else pageIndex - 1,
                    nextKey = nextkey
                )

            } else {
                // Handle unsuccessful response and set error message in ViewModel
                LoadResult.Error(HttpException(response))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}