package com.sunaa.apikeycall.ui.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.sunaa.apikeycall.data.remote.Data
import com.sunaa.apikeycall.data.repo.CrickRepoImp
import com.sunaa.apikeycall.data.repo.CricketerPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiService: CrickRepoImp
) : ViewModel() {
    private val _playerInfo = MutableStateFlow<List<Data>>(emptyList())
    val playerInfo: StateFlow<List<Data>> = _playerInfo.asStateFlow()
    val pagedItems = Pager(
        PagingConfig(
            pageSize = 25,
            prefetchDistance = 5
        )
    ) {
        CricketerPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)


    //    private val _playerInfo = MutableStateFlow<List<Data?>>(emptyList())
/*    fun fetchData() {
        viewModelScope.launch {
            try {
                val response = apiService.getPlayers(0)
                if (response.isSuccessful) {
                    response.body()?.let { apiResponse ->
                        val players = apiResponse.data // This is your list of Player objects
                        // Handle your player data here
                        _playerInfo.value = players
                        Log.i("players",players.toString())
                    }
                } else {
                    Log.i("kerr", response.errorBody()?.string() ?: "Unknown error")
                }
            } catch (e: Exception) {
                Log.i("kerror", e.toString())
            }
        }
    }*/
}