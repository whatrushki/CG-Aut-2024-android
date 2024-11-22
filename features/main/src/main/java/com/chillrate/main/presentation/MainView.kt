package com.chillrate.main.presentation

import androidx.compose.runtime.Composable
import com.chillrate.foundation.core.Listener
import com.chillrate.main.domain.models.MainAction
import com.chillrate.main.domain.models.MainState

@Composable
fun MainView(
    state: MainState,
    listener: Listener<MainAction>
) {
}