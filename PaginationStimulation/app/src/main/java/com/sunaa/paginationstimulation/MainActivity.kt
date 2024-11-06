package com.sunaa.paginationstimulation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sunaa.paginationstimulation.ui.theme.PaginationStimulationTheme
import com.sunaa.paginationstimulation.ui.view.ItemList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PaginationStimulationTheme {
                ItemList()
            }
        }
    }
}

