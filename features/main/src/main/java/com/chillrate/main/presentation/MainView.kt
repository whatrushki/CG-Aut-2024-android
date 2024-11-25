package com.chillrate.main.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chillrate.foundation.core.Listener
import com.chillrate.main.children.live.navigation.LiveProvider
import com.chillrate.main.children.profile.domain.models.ProfileEvent
import com.chillrate.main.children.profile.domain.models.ProfileState
import com.chillrate.main.presentation.MainFeature.Companion.children
import com.chillrate.main.presentation.MainFeature.Companion.navList
import com.chillrate.main.presentation.components.SensorConnect
import com.chillrate.navigation.bottom_navigation.BottomNavBar
import com.chillrate.navigation.core.NavigationHost
import com.chillrate.navigation.core.rememberHostNavigator
import com.chillrate.ui.components.widget.LocalSheetProvider
import com.chillrate.ui.icons.BluetoothActive
import com.chillrate.ui.theme.SHUIIcons
import com.chillrate.ui.theme.SHUITheme.palettes

@Composable
fun MainView(
    state: ProfileState,
    listener: Listener<ProfileEvent>
) {
    val navigator = rememberHostNavigator()
    val sheetProvider = LocalSheetProvider.current

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                containerColor = palettes.card,
                onClick = {
                    sheetProvider.setContent(SensorConnect)
                    sheetProvider.open()
                }
            ) {
                Icon(
                    SHUIIcons.BluetoothActive,
                    contentDescription = "",
                    tint = palettes.cardForeground,
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        bottomBar = {
            BottomNavBar(
                navigator = navigator,
                screens = navList
            )
        }
    ) {
        NavigationHost(
            navigator = navigator,
            start = LiveProvider,
            registry = children,
            modifier = Modifier
                .background(palettes.background)
                .padding(it)
        )
    }
}
