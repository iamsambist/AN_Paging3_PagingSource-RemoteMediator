package com.sunaa.apikeycall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sunaa.apikeycall.ui.theme.ApiKeyCallTheme
import com.sunaa.apikeycall.ui.view.ScreenMainView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApiKeyCallTheme {
                ScreenMainView()
            }
        }
    }
}
