package com.chillrate.main.children.live.domain

import com.chillrate.foundation.core.UIController
import com.chillrate.main.children.live.domain.models.LiveEvent
import com.chillrate.main.children.live.domain.models.LiveState
import com.chillrate.main.children.room.domain.models.RoomAction
import com.chillrate.remote.callibri.src.CallibriRepository

class LiveController(
    private val callibriRepository: CallibriRepository
) : UIController<LiveState, RoomAction, LiveEvent>(
    LiveState()
) {
    override fun obtainEvent(viewEvent: LiveEvent) = when (viewEvent) {
        LiveEvent.Init -> {}
        else -> {}
    }

    fun init() {}

}