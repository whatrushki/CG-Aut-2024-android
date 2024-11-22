package com.chillrate.auth.login.domain

import com.chillrate.auth.register.domain.models.LoginAction
import com.chillrate.auth.register.domain.models.LoginEvent
import com.chillrate.auth.register.domain.models.LoginState
import com.chillrate.foundation.core.UIController

class LoginController : UIController<LoginState, LoginAction, LoginEvent>(
    LoginState()
) {
    override fun obtainEvent(viewEvent: LoginEvent) = when (viewEvent) {
        LoginEvent.Init -> {}
        else -> {}
    }
}