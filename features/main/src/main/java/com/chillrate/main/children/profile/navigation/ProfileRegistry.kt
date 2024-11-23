package com.chillrate.main.children.profile.navigation

import com.chillrate.main.children.profile.presentation.ProfileFeature
import com.chillrate.navigation.core.NavProvider
import com.chillrate.navigation.core.Registry
import com.chillrate.navigation.core.register
import kotlinx.serialization.Serializable

@Serializable
object ProfileProvider : NavProvider()

val profileRegistry: Registry = {
    register(ProfileFeature::class)
}