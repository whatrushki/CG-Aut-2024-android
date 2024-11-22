package com.chillrate.auth.register.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chillrate.auth.login.domain.RegisterController
import com.chillrate.auth.register.domain.models.LoginEvent
import com.chillrate.auth.register.navigation.RegisterProvider
import com.chillrate.foundation.core.Feature
import com.chillrate.navigation.core.NavComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RegisterFeature(
    override val data: RegisterProvider
) : Feature<RegisterController, LoginEvent>(),
    NavComponent<RegisterProvider>,
    KoinComponent {
    override val controller: RegisterController by inject()

    @Composable
    override fun content(modifier: Modifier) {
    }
}