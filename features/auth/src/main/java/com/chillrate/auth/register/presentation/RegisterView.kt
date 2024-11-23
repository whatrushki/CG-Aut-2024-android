package com.chillrate.auth.register.presentation

import androidx.compose.runtime.Composable
import com.chillrate.auth.register.domain.models.RegisterAction
import com.chillrate.auth.register.domain.models.RegisterState
import com.chillrate.foundation.core.Listener

@Composable
fun RegisterView(
    state: RegisterState,
    listener: Listener<RegisterAction>
) {
}