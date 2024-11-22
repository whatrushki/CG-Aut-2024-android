package com.chillrate.auth.login.presentation

import androidx.compose.runtime.Composable
import com.chillrate.auth.register.domain.models.LoginAction
import com.chillrate.auth.register.domain.models.LoginState
import com.chillrate.foundation.core.Listener

@Composable
fun LoginView(
    state: LoginState,
    listener: Listener<LoginAction>
) {
}