package com.chillrate.remote.callibri.src

import android.util.Log
import com.neurosdk2.neuro.types.CallibriSignalData
import com.neurosdk2.neuro.types.SensorInfo
import kotlinx.coroutines.flow.MutableStateFlow

class CallibriRepository(
    val controller: CallibriController
) {
    val visibleSensors = MutableStateFlow<List<SensorInfo>>(emptyList())
    var lastSavedPack = 0
    val signalData = mutableListOf<CallibriSignalData>()
    val dataFlow = MutableStateFlow<List<Double>>(emptyList())

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
        controller.startEnvelope {
            it.first().sample
        }
        controller.startSignal { signal ->
            signalData.addAll(signal)

            val lastPack = signal.lastOrNull() ?: return@startSignal

            if (lastPack.packNum - lastSavedPack > 80) {
                dataFlow.value = signalData.map { it.samples.map { it * 10000.0 } }.flatten()
                lastSavedPack = lastPack.packNum

                if (signalData.size > 500) {
                    val sub = signalData.subList(signalData.size - 300, signalData.size).toList()
                    signalData.clear()
                    signalData.addAll(sub)
                }

                Log.d("d", "ecg data: ${dataFlow.value}")
            }

            signalStarted = true
        }
    }

    fun stopSignal() {
        controller.stopSignal()
        lastSavedPack = 0
        signalData.clear()
        signalStarted = false
    }
}
