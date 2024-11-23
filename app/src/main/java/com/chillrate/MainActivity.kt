package com.chillrate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.chillrate.splash.navigation.SplashProvider
import com.chillrate.splash.presentation.SplashFeature
import com.chillrate.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
//                AppNavHost()
                val splash = remember { SplashFeature(SplashProvider) }
                splash.content(Modifier)
            }
        }
    }
}