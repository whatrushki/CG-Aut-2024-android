package com.chillrate.main.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.chillrate.foundation.core.Feature
import com.chillrate.main.children.live.navigation.LiveProvider
import com.chillrate.main.children.live.navigation.liveRegistry
import com.chillrate.main.children.profile.domain.ProfileController
import com.chillrate.main.children.profile.domain.models.ProfileEvent
import com.chillrate.main.children.profile.navigation.ProfileProvider
import com.chillrate.main.children.profile.navigation.profileRegistry
import com.chillrate.main.children.room.navigation.RoomProvider
import com.chillrate.main.children.room.navigation.roomRegistry
import com.chillrate.main.navigation.MainProvider
import com.chillrate.navigation.bottom_navigation.navItem
import com.chillrate.navigation.core.NavComponent
import com.chillrate.navigation.core.Registry
import com.chillrate.ui.icons.Donut
import com.chillrate.ui.icons.Room
import com.chillrate.ui.icons.User
import com.chillrate.ui.theme.SHUIIcons
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainFeature(
    override val data: MainProvider
) : Feature<ProfileController, ProfileEvent>(),
    NavComponent<MainProvider>,
    KoinComponent {
    override val controller: ProfileController by inject()

    internal companion object {
        val children: Registry = {
            profileRegistry()
            liveRegistry()
            roomRegistry()
        }

        val navList = listOf(
            navItem(
                name = "Главная",
                icon = SHUIIcons.Donut,
                provider = LiveProvider
            ),
            navItem(
                name = "Комната",
                icon = SHUIIcons.Room,
                provider = RoomProvider
            ),
            navItem(
                name = "Профиль",
                icon = SHUIIcons.User,
                provider = ProfileProvider
            )
        )
    }

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()

        LaunchedEffect(Unit) {
            listener(ProfileEvent.Init)
        }

        MainView(state, listener)

        when (action) {
            else -> {}
        }
    }
}