package com.chillrate.main.children.live.presentation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.chillrate.foundation.core.Listener
import com.chillrate.foundation.services.LocalSheetProvider
import com.chillrate.main.children.live.domain.models.LiveEvent
import com.chillrate.main.children.live.domain.models.LiveState
import com.chillrate.main.presentation.components.SensorConnect
import com.chillrate.remote.callibri.src.CallibriRepository
import org.koin.compose.koinInject

@Composable
fun RoomView(
    state: LiveState,
    listener: Listener<LiveEvent>
) {
    val callibriRepository: CallibriRepository = koinInject()
    val sheetProvider = LocalSheetProvider.current

    val sensorConnected by callibriRepository.controller.sensorConnected.collectAsState()

    sheetProvider.setContent(SensorConnect)

    LaunchedEffect(sensorConnected) {
        Log.d("d", "sensor connected: $sensorConnected")
        if (!sensorConnected) sheetProvider.open()
        else sheetProvider.close()
    }
}