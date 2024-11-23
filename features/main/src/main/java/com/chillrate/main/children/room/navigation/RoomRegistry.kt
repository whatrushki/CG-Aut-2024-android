package com.chillrate.main.children.room.navigation

import com.chillrate.main.children.room.presentation.RoomFeature
import com.chillrate.navigation.core.NavProvider
import com.chillrate.navigation.core.Registry
import com.chillrate.navigation.core.register
import kotlinx.serialization.Serializable

@Serializable
object RoomProvider : NavProvider()

val roomRegistry: Registry = {
    register(RoomFeature::class)
}