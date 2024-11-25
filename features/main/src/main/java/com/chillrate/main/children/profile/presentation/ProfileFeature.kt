package com.chillrate.main.children.profile.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.chillrate.foundation.core.Feature
import com.chillrate.ui.components.widget.LocalSheetProvider
import com.chillrate.main.children.profile.domain.ProfileController
import com.chillrate.main.children.profile.domain.models.ProfileDestination
import com.chillrate.main.children.profile.domain.models.ProfileEvent
import com.chillrate.main.children.profile.navigation.ProfileProvider
import com.chillrate.main.children.profile.presentation.components.LoginForm
import com.chillrate.main.children.profile.presentation.components.RegisterForm
import com.chillrate.navigation.core.NavComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ProfileFeature(
    override val data: ProfileProvider
) : Feature<ProfileController, ProfileEvent>(),
    NavComponent<ProfileProvider>,
    KoinComponent {
    override val controller: ProfileController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()

        LaunchedEffect(Unit) {
            listener(ProfileEvent.Init)
        }

        ProfileView(state, listener)

        val sheetProvider = LocalSheetProvider.current


        when (state.destination) {
            ProfileDestination.None -> sheetProvider.close()
            is ProfileDestination.Login -> sheetProvider.apply {
                state.destination as ProfileDestination.Login
                setContent {
                    LoginForm(state, listener)
                }
                open()
            }

            is ProfileDestination.Register -> sheetProvider.apply {
                setContent {
                    RegisterForm(state, listener)
                }
                open()
            }

        }

        DisposableEffect(Unit) {
            onDispose {
                sheetProvider.setContent {}
                sheetProvider.close()
            }
        }
    }
}