package com.sunaa.pagingwithcache.ui.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import com.sunaa.pagingwithcache.data.room.SeriesEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    pager: Pager<Int,SeriesEntity>
)  : ViewModel() {
    val seriesFlow = pager.flow.cachedIn(viewModelScope)

}