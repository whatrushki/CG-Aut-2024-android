package com.chillrate.auth.login.domain.models

import com.chillrate.auth.register.domain.models.LoginEvent

sealed interface LoginEvent {
    data object Init : LoginEvent
}