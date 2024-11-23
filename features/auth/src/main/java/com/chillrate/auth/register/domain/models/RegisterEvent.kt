package com.chillrate.auth.register.domain.models

sealed interface RegisterEvent {
    data object Init : RegisterEvent
}