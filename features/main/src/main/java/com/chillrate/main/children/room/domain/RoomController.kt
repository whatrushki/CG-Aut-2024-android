package com.chillrate.main.children.room.domain

import com.chillrate.foundation.core.UIController
import com.chillrate.main.children.room.domain.models.RoomAction
import com.chillrate.main.children.room.domain.models.RoomEvent
import com.chillrate.main.children.room.domain.models.RoomState
import com.chillrate.remote.callibri.src.CallibriRepository

class RoomController(
    private val callibriRepository: CallibriRepository
) : UIController<RoomState, RoomAction, RoomEvent>(
    RoomState()
) {
    override fun obtainEvent(viewEvent: RoomEvent) = when (viewEvent) {
        RoomEvent.Init -> {}
        else -> {}
    }

    fun init() {}

}