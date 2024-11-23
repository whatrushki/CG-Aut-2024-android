package com.chillrate.main.children.live.domain.models

import com.neurosdk2.neuro.types.SensorInfo

data class LiveState(
    val css: List<Float> = listOf(),
    val strongIndex: List<Float> = listOf(),
    val destination: LiveDestination = LiveDestination.None
)

sealed interface LiveDestination {
    data object None : LiveDestination
    data class Live(
        val sensors: SensorInfo
    ) : LiveDestination
}