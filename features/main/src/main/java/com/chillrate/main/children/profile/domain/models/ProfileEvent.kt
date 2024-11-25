package com.chillrate.main.children.profile.domain.models

sealed interface ProfileEvent {
    data object Init : ProfileEvent
    data object OnLoginClicked : ProfileEvent
    data object OnRegisterClicked : ProfileEvent

    data class OnFocusTakenOffOnLogin(
        val username: String,
        val password: String
    ) : ProfileEvent

    data class OnFocusTakenOffOnRegister(
        val fullName: String,
        val username: String,
        val email: String,
        val password: String,
    ) : ProfileEvent

    data object OnSubmitRegisterClicked : ProfileEvent
    data object OnSubmitLoginClicked : ProfileEvent
}