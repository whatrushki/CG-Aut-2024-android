package com.chillrate.splash.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.whatrushik.what_shadcn_ui.core.react.useState
import com.chillrate.foundation.core.Feature
import com.chillrate.foundation.utils.PermissionRequired
import com.chillrate.navigation.core.NavComponent
import com.chillrate.remote.callibri.src.CallibriController
import com.chillrate.splash.domain.SplashController
import com.chillrate.splash.domain.models.SplashEvent
import com.chillrate.splash.navigation.SplashProvider
import com.neurosdk2.neuro.types.SensorInfo
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SplashFeature(
    override val data: SplashProvider
) : Feature<SplashController, SplashEvent>(),
    NavComponent<SplashProvider>,
    KoinComponent {
    override val controller: SplashController by inject()

    @SuppressLint("InlinedApi")
    @Composable
    override fun content(modifier: Modifier) = Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        val callibriController: CallibriController by inject()
        var sensors by remember { mutableStateOf(emptyList<SensorInfo>()) }

        var started by useState(false)

        Text("Hi")

        val scope = rememberCoroutineScope()

        PermissionRequired(
            permission = Manifest.permission.BLUETOOTH_SCAN,
            permissionName = "Bluetooth",
        ) {
            Button(
                onClick = {
                    if (started) return@Button
                    started = true
                    Log.d("d", "start search")
                    scope.launch {
                        callibriController.startSearch { scanner, sensorInfos ->
                            Log.d("d", "sensors: $sensorInfos")
                            sensors = sensorInfos
                        }
                    }
                }
            ) { Text("Start search") }
        }

        sensors.forEach { Text(it.name) }
    }
}