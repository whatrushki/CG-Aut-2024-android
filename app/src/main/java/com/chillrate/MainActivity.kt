package com.chillrate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor

import androidx.compose.ui.unit.dp
import com.chillrate.ui.theme.AppTheme
import ir.ehsannarmani.compose_charts.LineChart
import ir.ehsannarmani.compose_charts.models.AnimationMode
import ir.ehsannarmani.compose_charts.models.DrawStyle
import ir.ehsannarmani.compose_charts.models.Line
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                var liveinfo by remember {
                    mutableStateOf(listOf(28.0, 41.0, 5.0, 10.0, 35.0))
                }

                val data = remember(liveinfo) {
                    listOf(
                        Line(
                            label = "Windows",
                            values = liveinfo.subList((liveinfo.size - 10).coerceAtLeast(0), liveinfo.lastIndex),
                            color = SolidColor(Color(0xFF23af92)),
                            firstGradientFillColor = Color.Transparent,
                            secondGradientFillColor = Color.Transparent,
                            drawStyle = DrawStyle.Stroke(width = 2.dp),
                            curvedEdges = false,
                            gradientAnimationDelay = 0L,
                            gradientAnimationSpec = tween(0),
                            strokeAnimationSpec = tween(0)
                        )
                    )
                }

                LineChart(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(100.dp),
                    data = data,
                    maxValue = 200.0,
                    minValue = 0.0
                )


                LaunchedEffect(Unit) {
                    while (true) {
                        liveinfo += liveinfo.random()
                        delay(1000L)
                    }
                }

            }
        }
    }

}

@Composable
fun EcgGraph(ecgData: List<Float>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .horizontalScroll(rememberScrollState())
            ) {
                val width = size.width
                val height = size.height
                val dataPoints = ecgData.size
                val xScale = width / dataPoints.toFloat()

                if (dataPoints > 0) {
                    val yScale = height / (ecgData.maxOrNull()?.toDouble()
                        ?: 1.0) // Prevents division by zero.
                    val path = Path()
                    path.moveTo(0f, height / 2f) // Start at the middle of the graph.
                    for (i in 0 until dataPoints) {
                        val x = i * xScale
                        val y = (ecgData[i].toDouble() * yScale).toFloat()
                        path.lineTo(x, height / 2f - y)
                    }
                    drawPath(path, Color.Red)
                }
            }
        }

        Text("ECG Data") // Add some labeling.
    }
}