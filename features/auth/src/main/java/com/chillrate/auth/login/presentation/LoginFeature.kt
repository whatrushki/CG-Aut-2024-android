package com.chillrate.auth.login.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.chillrate.auth.login.domain.LoginController
import com.chillrate.auth.login.domain.models.LoginAction
import com.chillrate.auth.login.domain.models.LoginEvent
import com.chillrate.auth.login.navigation.LoginProvider
import com.chillrate.auth.register.navigation.RegisterProvider
import com.chillrate.foundation.core.Feature
import com.chillrate.main.navigation.MainProvider
import com.chillrate.navigation.core.NavComponent
import com.chillrate.navigation.core.rememberNavigator
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoginFeature(
    override val data: LoginProvider
) :
    Feature<LoginController, LoginEvent>(),
    NavComponent<LoginProvider>,
    KoinComponent {
    override val controller: LoginController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()
        val navigator = rememberNavigator()

        LaunchedEffect(Unit) {
            listener(LoginEvent.Init)
        }

        LoginView(state, listener)

        when (action) {
            null -> Unit

            LoginAction.NavigateToRegister -> {
                controller.clearAction()
                navigator.c.navigate(RegisterProvider)
            }

            LoginAction.NavigateToMain -> {
                controller.clearAction()
                navigator.c.navigate(MainProvider) {
                    popUpTo(0) { inclusive = true }
                }
            }
        }
    }
}