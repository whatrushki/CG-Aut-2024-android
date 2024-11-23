package com.chillrate.main.children.live.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.chillrate.foundation.core.Feature
import com.chillrate.main.children.live.domain.LiveController
import com.chillrate.main.children.live.domain.models.LiveEvent
import com.chillrate.main.children.live.navigation.LiveProvider
import com.chillrate.navigation.core.NavComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LiveFeature(
    override val data: LiveProvider
) : Feature<LiveController, LiveEvent>(),
    NavComponent<LiveProvider>,
    KoinComponent {
    override val controller: LiveController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()

        LaunchedEffect(Unit) {
            listener(LiveEvent.Init)
        }

        RoomView(state, listener)

        when (action) {
            else -> {}
        }
    }
}