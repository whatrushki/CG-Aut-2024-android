package com.chillrate.splash.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chillrate.foundation.core.Feature
import com.chillrate.navigation.core.NavComponent
import com.chillrate.splash.domain.SplashController
import com.chillrate.splash.domain.models.SplashEvent
import com.chillrate.splash.navigation.MainProvider
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SplashFeature(
    override val data: MainProvider
) : Feature<SplashController, SplashEvent>(),
    NavComponent<MainProvider>,
    KoinComponent {
    override val controller: SplashController by inject()

    @Composable
    override fun content(modifier: Modifier) {
    }
}