package com.chillrate.auth.register.domain.models

sealed interface LoginEvent {
    data object Init : LoginEvent
}