package com.chillrate.splash.domain

import com.chillrate.foundation.core.UIController
import com.chillrate.splash.domain.models.SplashAction
import com.chillrate.splash.domain.models.SplashEvent
import com.chillrate.splash.domain.models.SplashState

class SplashController : UIController<SplashState, SplashAction, SplashEvent>(
    SplashState()
) {
    override fun obtainEvent(viewEvent: SplashEvent) = when (viewEvent) {
        SplashEvent.Init -> {}
        else -> {}
    }
}