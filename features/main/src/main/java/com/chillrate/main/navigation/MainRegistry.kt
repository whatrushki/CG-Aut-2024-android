package com.chillrate.main.navigation

import com.chillrate.main.presentation.MainFeature
import com.chillrate.navigation.core.NavProvider
import com.chillrate.navigation.core.Registry
import com.chillrate.navigation.core.register
import kotlinx.serialization.Serializable

@Serializable
object MainProvider : NavProvider()

val mainRegistry: Registry = {
    register(MainFeature::class)
}