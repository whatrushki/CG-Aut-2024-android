package com.chillrate.auth.login.domain.models

sealed interface LoginEvent {
    data object Init : LoginEvent
}