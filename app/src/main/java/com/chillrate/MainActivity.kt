package com.chillrate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.chillrate.ui.components.widget.ProvideGlobalSheet
import com.chillrate.navigation.AppNavHost
import com.chillrate.ui.theme.AppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                ProvideGlobalSheet {
                    AppNavHost()
                }
            }
        }
    }
}