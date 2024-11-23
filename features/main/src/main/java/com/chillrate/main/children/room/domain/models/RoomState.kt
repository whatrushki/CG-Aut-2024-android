package com.chillrate.main.children.room.domain.models


data class RoomState(
    val destination: RoomDestination = RoomDestination.None
)

sealed interface RoomDestination {
    data object None : RoomDestination
}