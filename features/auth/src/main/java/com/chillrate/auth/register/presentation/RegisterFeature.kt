package com.chillrate.auth.register.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.chillrate.auth.register.domain.RegisterController
import com.chillrate.auth.register.domain.models.RegisterEvent
import com.chillrate.auth.register.navigation.RegisterProvider
import com.chillrate.foundation.core.Feature
import com.chillrate.navigation.core.NavComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RegisterFeature(
    override val data: RegisterProvider
) :
    Feature<RegisterController, RegisterEvent>(),
    NavComponent<RegisterProvider>,
    KoinComponent {
    override val controller: RegisterController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()

        LaunchedEffect(Unit) {
            listener(RegisterEvent.Init)
        }

        RegisterView(state, listener)

        when (action) {
            else -> {}
        }
    }
}