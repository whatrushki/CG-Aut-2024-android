package com.chillrate.remote.callibri.src

import android.util.Log
import com.neurosdk2.neuro.types.CallibriSignalData
import com.neurosdk2.neuro.types.SensorInfo
import kotlinx.coroutines.flow.MutableStateFlow

class CallibriRepository(
    val controller: CallibriController
) {
    val visibleSensors = MutableStateFlow<List<SensorInfo>>(emptyList())
    val data = MutableStateFlow<List<CallibriSignalData>>(emptyList())
    private var signalStarted = false
    val hasSignal get() = controller.sensorConnected.value && signalStarted

    fun startSearch() {
        controller.startSearch { scanner, sensorInfos ->
            visibleSensors.value = sensorInfos
        }
    }

    fun stopSearch() {
        controller.stopSearch()
        visibleSensors.value = emptyList()
    }

    fun startSignal() {
        controller.startSignal {
            data.value += it
            Log.d("d", "signal: $it")
        }
        signalStarted = true
    }

    fun stopSignal() {
        controller.stopSignal()
        data.value += emptyList()
        signalStarted = false
    }
}