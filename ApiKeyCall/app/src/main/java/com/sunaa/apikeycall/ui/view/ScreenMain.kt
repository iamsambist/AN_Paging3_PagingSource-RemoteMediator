package com.sunaa.apikeycall.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.sunaa.apikeycall.data.remote.Data

@Composable
fun ScreenMainView(mainViewModel: MainViewModel = hiltViewModel()) {
//    LaunchedEffect(Unit) {
//        mainViewModel.fetchData()
//    }
//    val players = mainViewModel.playerInfo.collectAsState()

    val players = mainViewModel.pagedItems.collectAsLazyPagingItems()
    LazyColumn(modifier = Modifier.fillMaxWidth().padding(WindowInsets.statusBars.asPaddingValues())) {
        items(players.itemCount) { index ->
            val item = players[index]
            item?.let {
                ItemRow(it)
            }
        }
        players.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(WindowInsets.statusBars.asPaddingValues()),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }

                loadState.append is LoadState.Loading -> {
                    item {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }

                loadState.append is LoadState.Error -> {
                    item { Text("Error Loading Data") }
                }
            }
        }
    }


}

@Composable
fun ItemRow(item: Data) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = item.name)
        Text(text = item.country)
    }
}
