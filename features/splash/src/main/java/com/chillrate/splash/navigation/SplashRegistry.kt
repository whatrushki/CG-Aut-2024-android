package com.chillrate.splash.navigation

import com.chillrate.navigation.core.NavProvider
import com.chillrate.navigation.core.Registry
import com.chillrate.navigation.core.register
import com.chillrate.splash.presentation.SplashFeature
import kotlinx.serialization.Serializable

@Serializable
object SplashProvider : NavProvider()

val splashRegistry: Registry = {
    register(SplashFeature::class)
}