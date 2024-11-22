package com.chillrate.auth.register.domain

import com.chillrate.auth.register.domain.models.RegisterAction
import com.chillrate.auth.register.domain.models.RegisterEvent
import com.chillrate.auth.register.domain.models.RegisterState
import com.chillrate.foundation.core.UIController

class RegisterController : UIController<RegisterState, RegisterAction, RegisterEvent>(
    RegisterState()
) {
    override fun obtainEvent(viewEvent: RegisterEvent) = when (viewEvent) {
        RegisterEvent.Init -> {}
        else -> {}
    }
}