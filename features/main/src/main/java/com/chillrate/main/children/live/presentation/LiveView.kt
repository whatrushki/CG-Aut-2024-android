package com.chillrate.main.children.live.presentation

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chillrate.foundation.core.Listener
import com.chillrate.foundation.utils.bluetoothConnectState
import com.chillrate.main.children.live.domain.models.LiveEvent
import com.chillrate.main.children.live.domain.models.LiveState
import com.chillrate.main.presentation.components.SensorConnect
import com.chillrate.remote.callibri.src.CallibriRepository
import com.chillrate.ui.components.spacer.Space
import com.chillrate.ui.components.styled_box.StyledBox
import com.chillrate.ui.components.widget.LocalSheetProvider
import com.chillrate.ui.icons.SignalTelevisor
import com.chillrate.ui.theme.SHUIColor
import com.chillrate.ui.theme.SHUIIcons
import com.chillrate.ui.theme.SHUITheme.palettes
import com.chillrate.ui.theme.SHUITheme.spacing
import com.chillrate.ui.theme.SHUITheme.typography
import ir.ehsannarmani.compose_charts.LineChart
import ir.ehsannarmani.compose_charts.models.DrawStyle
import ir.ehsannarmani.compose_charts.models.HorizontalIndicatorProperties
import ir.ehsannarmani.compose_charts.models.LabelHelperProperties
import ir.ehsannarmani.compose_charts.models.Line
import ir.ehsannarmani.compose_charts.models.ZeroLineProperties
import org.koin.compose.koinInject

@Composable
fun RoomView(
    state: LiveState,
    listener: Listener<LiveEvent>
) = Column(
    verticalArrangement = Arrangement.Center,
    modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
) {
    val callibriRepository: CallibriRepository = koinInject()
    val sheetProvider = LocalSheetProvider.current
    val bluetoothConnected = bluetoothConnectState()

    val sensorConnected by callibriRepository.controller.sensorConnected.collectAsState()
    val data by callibriRepository.dataFlow.collectAsState()
    sheetProvider.setContent(SensorConnect)

    LaunchedEffect(sensorConnected) {
        Log.d("d", "sensor connected: $sensorConnected")
        if (!sensorConnected) sheetProvider.open()
        else sheetProvider.close()
    }

    Space(spacing.md)

    if (!sensorConnected) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(200.dp)
            ) {
                Image(
                    imageVector = SHUIIcons.SignalTelevisor,
                    contentDescription = ""
                )

                Space(spacing.md)

                Text(
                    if (bluetoothConnected) "Датчик не подключен" else "Для работы требуется включенный Bluetooth",
                    style = typography.bodyMedium,
                    color = palettes.foreground,
                    textAlign = TextAlign.Center
                )
            }
        }
    } else StyledBox(
        Modifier
            .height(500.dp)
            .padding(14.dp)
    ) {
        LineChart(
            zeroLineProperties = ZeroLineProperties(
                enabled = true,
                color = SolidColor(SHUIColor.red.i500)
            ),
            labelHelperProperties = LabelHelperProperties(
                enabled = true,
                textStyle = TextStyle(color = palettes.foreground)
            ),
            indicatorProperties = HorizontalIndicatorProperties(
                textStyle = TextStyle(color = palettes.foreground), padding = 16.dp
            ),
            data = listOf(
                Line(
                    label = "Частота сердцебиения",
                    values = data,
                    color = SolidColor(palettes.chart1),
                    firstGradientFillColor = Color.Transparent,
                    secondGradientFillColor = Color.Transparent,
                    strokeAnimationSpec = tween(0),
                    gradientAnimationSpec = tween(0),
                    gradientAnimationDelay = 0,
                    drawStyle = DrawStyle.Stroke(width = 2.dp)
                )
            )
        )
    }
}