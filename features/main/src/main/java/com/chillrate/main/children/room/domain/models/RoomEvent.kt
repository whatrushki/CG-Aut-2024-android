package com.chillrate.main.children.room.domain.models

sealed interface RoomEvent {
    data object Init : RoomEvent
}