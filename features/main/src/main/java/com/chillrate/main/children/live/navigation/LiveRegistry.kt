package com.chillrate.main.children.live.navigation

import com.chillrate.main.children.live.presentation.LiveFeature
import com.chillrate.navigation.core.NavProvider
import com.chillrate.navigation.core.Registry
import com.chillrate.navigation.core.register
import kotlinx.serialization.Serializable

@Serializable
object LiveProvider : NavProvider()

val liveRegistry: Registry = {
    register(LiveFeature::class)
}