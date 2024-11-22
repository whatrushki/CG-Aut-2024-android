package com.chillrate.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chillrate.auth.login.navigation.loginRegistry
import com.chillrate.auth.register.navigation.registerRegistry
import com.chillrate.main.navigation.mainRegistry
import com.chillrate.navigation.core.NavigationHost
import com.chillrate.navigation.core.Navigator
import com.chillrate.navigation.core.rememberHostNavigator
import com.chillrate.splash.navigation.SplashProvider
import com.chillrate.splash.navigation.splashRegistry
import com.chillrate.ui.theme.SHUITheme.palettes


@Composable
fun AppNavHost(
    navigator: Navigator = rememberHostNavigator()
) = NavigationHost(
    start = SplashProvider,
    navigator = navigator,
    modifier = Modifier
        .fillMaxSize()
        .background(palettes.background)
) {
    mainRegistry()
    loginRegistry()
    registerRegistry()
    splashRegistry()
}