package com.chillrate.auth.login.domain.models

sealed interface LoginAction {
    data object NavigateToMain : LoginAction
    data object NavigateToRegister : LoginAction
}