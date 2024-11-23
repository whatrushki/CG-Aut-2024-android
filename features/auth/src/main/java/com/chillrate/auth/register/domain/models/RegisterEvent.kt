package com.chillrate.auth.register.domain.models

sealed interface RegisterEvent {




    data object Init : RegisterEvent
    data object OnRegisterClicked : RegisterEvent
    data class OnFocusTakenOff(
        val name: String,
        val surname: String,
        val patronymic: String,
        val login: String,
        val password: String,
        val repeatPassword: String) : RegisterEvent
}