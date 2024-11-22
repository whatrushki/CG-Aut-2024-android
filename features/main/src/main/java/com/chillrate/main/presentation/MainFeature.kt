package com.chillrate.main.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chillrate.foundation.core.Feature
import com.chillrate.main.domain.MainController
import com.chillrate.main.domain.models.MainEvent
import com.chillrate.main.navigation.MainProvider
import com.chillrate.navigation.core.NavComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainFeature(
    override val data: MainProvider
) : Feature<MainController, MainEvent>(),
    NavComponent<MainProvider>,
    KoinComponent {
    override val controller: MainController by inject()

    @Composable
    override fun content(modifier: Modifier) {
    }
}