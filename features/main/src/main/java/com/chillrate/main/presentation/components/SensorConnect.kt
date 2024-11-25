package com.chillrate.main.presentation.components

import android.Manifest
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.whatrushik.what_shadcn_ui.core.react.useState
import com.chillrate.foundation.utils.bluetoothConnectState
import com.chillrate.remote.callibri.src.CallibriRepository
import com.chillrate.ui.components.spacer.Space
import com.chillrate.ui.components.widget.PermissionRequired
import com.chillrate.ui.icons.Beacon
import com.chillrate.ui.icons.BluetoothActive
import com.chillrate.ui.icons.MapPoint
import com.chillrate.ui.theme.SHUIIcons
import com.chillrate.ui.theme.SHUITheme.palettes
import com.chillrate.ui.theme.SHUITheme.spacing
import com.chillrate.ui.theme.SHUITheme.typography
import com.neurosdk2.neuro.types.SensorInfo
import com.neurosdk2.neuro.types.SensorState
import org.koin.compose.koinInject


@SuppressLint("InlinedApi")
val SensorConnect = @Composable {
    PermissionRequired(
        Manifest.permission.BLUETOOTH_SCAN,
        "Bluetooth"
    ) {
        var connectingTo by useState<String?>(null)
        val bluetoothEnabled = bluetoothConnectState()
        val callibriRepository: CallibriRepository = koinInject()
        val sensors by callibriRepository.visibleSensors.collectAsState()

        LaunchedEffect(Unit) {
            callibriRepository.startSearch()
        }

        DisposableEffect(Unit) {
            onDispose {
                callibriRepository.stopSearch()
            }
        }

        Column {
            if (!bluetoothEnabled) Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    SHUIIcons.BluetoothActive,
                    contentDescription = "",
                    tint = palettes.foreground,
                    modifier = Modifier.size(24.dp)
                )

                Space(spacing.sm)

                Text(
                    "Включите Bluetooth",
                    style = typography.subtle,
                    color = palettes.foreground
                )
            } else if (sensors.isEmpty()) Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    SHUIIcons.MapPoint,
                    contentDescription = "",
                    tint = palettes.foreground,
                    modifier = Modifier.size(24.dp)
                )

                Space(spacing.sm)

                Text(
                    "Нет сенсоров поблизости",
                    style = typography.subtle,
                    color = palettes.foreground
                )
            } else sensors.forEach { sensor ->
                SensorInfoItem(
                    sensor,
                    availableToConnect = connectingTo != sensor.address
                ) {
                    Log.d("d", "connecting2")
                    callibriRepository.controller.disconnectCurrent()
                    callibriRepository.controller.createAndConnect(sensor) {
                        if (it == SensorState.StateInRange) {
                            Log.d("d", "connected")
                            connectingTo = sensor.address
                            callibriRepository.startSignal()
                        } else {
                            Log.d("d", "not connected")
                            connectingTo = null
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SensorInfoItem(
    sensor: SensorInfo,
    availableToConnect: Boolean = true,
    onClick: () -> Unit
) = Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Min)
        .padding(spacing.sm.dp)
) {
    Row {
        Icon(
            SHUIIcons.Beacon,
            contentDescription = "",
            tint = palettes.foreground,
            modifier = Modifier.size(30.dp)
        )

        Space(spacing.sm)

        Column {
            Text(
                sensor.name,
                style = typography.subleSemibold,
                color = palettes.secondaryForeground
            )

            Text(
                "MAC: ${sensor.address}",
                style = typography.subtle,
                color = palettes.secondaryForeground
            )
        }
    }

    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = palettes.primary,
            contentColor = palettes.primaryForeground,
            disabledContentColor = palettes.mutedForeground,
            disabledContainerColor = palettes.muted
        ),
        enabled = availableToConnect,
        onClick = {
            Log.d("d", "connecting")
            onClick()
        }
    ) {
        Text("Подключить")
    }
}