package com.chillrate.auth.register.navigation

import com.chillrate.auth.register.presentation.RegisterFeature
import com.chillrate.navigation.core.NavProvider
import com.chillrate.navigation.core.Registry
import com.chillrate.navigation.core.register
import kotlinx.serialization.Serializable

@Serializable
object RegisterProvider : NavProvider()

val registerRegistry: Registry = {
    register(RegisterFeature::class)
}