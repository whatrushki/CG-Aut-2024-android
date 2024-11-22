package com.chillrate.main.domain

import com.chillrate.foundation.core.UIController
import com.chillrate.main.domain.models.MainAction
import com.chillrate.main.domain.models.MainEvent
import com.chillrate.main.domain.models.MainState

class MainController : UIController<MainState, MainAction, MainEvent>(
    MainState()
) {
    override fun obtainEvent(viewEvent: MainEvent) = when (viewEvent) {
        MainEvent.Init -> {}
        else -> {}
    }
}