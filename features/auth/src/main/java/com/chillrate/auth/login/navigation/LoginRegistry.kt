package com.chillrate.auth.login.navigation

import com.chillrate.auth.login.presentation.LoginFeature
import com.chillrate.navigation.core.NavProvider
import com.chillrate.navigation.core.Registry
import com.chillrate.navigation.core.register
import kotlinx.serialization.Serializable

@Serializable
object LoginProvider : NavProvider()

val loginRegistry: Registry = {
    register(LoginFeature::class)
}