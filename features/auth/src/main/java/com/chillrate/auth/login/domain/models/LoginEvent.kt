package com.chillrate.auth.login.domain.models

sealed interface LoginEvent {
    data object Init : LoginEvent
   data object OnLoginClicked : LoginEvent
    data object OnRegisterClicked : LoginEvent

    data class OnFocusTakenOff(
        val login : String,
        val password : String
    ) : LoginEvent
}