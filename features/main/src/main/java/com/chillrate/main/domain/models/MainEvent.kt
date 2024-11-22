package com.chillrate.main.domain.models

sealed interface MainEvent {
    data object Init : MainEvent
}