package com.chillrate.auth.login.domain

import com.chillrate.auth.register.domain.models.RegisterAction
import com.chillrate.auth.register.domain.models.RegisterEvent
import com.chillrate.auth.register.domain.models.RegisterState
import com.chillrate.foundation.core.UIController

class LoginController : UIController<RegisterState, RegisterAction, RegisterEvent>(
    RegisterState()
) {
    override fun obtainEvent(viewEvent: RegisterEvent) = when (viewEvent) {
        RegisterEvent.Init -> {}
        else -> {}
    }
}