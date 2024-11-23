package com.chillrate.main.children.room.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.chillrate.foundation.core.Feature
import com.chillrate.main.children.room.domain.RoomController
import com.chillrate.main.children.room.domain.models.RoomEvent
import com.chillrate.main.children.room.navigation.RoomProvider
import com.chillrate.navigation.core.NavComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RoomFeature(
    override val data: RoomProvider
) : Feature<RoomController, RoomEvent>(),
    NavComponent<RoomProvider>,
    KoinComponent {
    override val controller: RoomController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()

        LaunchedEffect(Unit) {
            listener(RoomEvent.Init)
        }

        RoomView(state, listener)

        when (action) {
            else -> {}
        }
    }
}