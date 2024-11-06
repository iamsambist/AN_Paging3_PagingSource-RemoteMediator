package com.sunaa.paginationstimulation.ui.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.sunaa.paginationstimulation.remote.FakeRepository
import com.sunaa.paginationstimulation.repo.ItemPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: FakeRepository
) : ViewModel() {
    val pagedItems = Pager(
        PagingConfig(
            pageSize = 20,
            prefetchDistance = 1
        )
    ) {
        ItemPagingSource(repository)
    }.flow.cachedIn(viewModelScope)
}