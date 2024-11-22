package com.chillrate.splash.domain.models

sealed interface SplashEvent {
    data object Init : SplashEvent
}