package com.chillrate.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.chillrate.ui.theme.SHUIIcons

val SHUIIcons.BluetoothActive: ImageVector
    get() {
        if (_BluetoothActive != null) {
            return _BluetoothActive!!
        }
        _BluetoothActive = ImageVector.Builder(
            name = "BluetoothActive",
            defaultWidth = 512.dp,
            defaultHeight = 512.dp,
            viewportWidth = 32f,
            viewportHeight = 32f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveToRelative(13.424f, 16f)
                lineToRelative(6.932f, -5.2f)
                arcToRelative(
                    0.999f,
                    0.999f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    0f,
                    -1.6f
                )
                lineToRelative(-8f, -6f)
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    -1.6f,
                    0.8f
                )
                verticalLineToRelative(10f)
                lineToRelative(-4.4f, -3.3f)
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -1.199f,
                    1.6f
                )
                lineTo(10.09f, 16f)
                lineToRelative(-4.933f, 3.7f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = false, 1.2f, 1.6f)
                lineToRelative(4.4f, -3.3f)
                verticalLineToRelative(10f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.6f, 0.8f)
                lineToRelative(8f, -6f)
                arcToRelative(
                    0.999f,
                    0.999f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    0f,
                    -1.6f
                )
                close()
                moveTo(12.757f, 6f)
                lineTo(18.09f, 10f)
                lineTo(12.757f, 14f)
                close()
                moveTo(12.757f, 26f)
                verticalLineToRelative(-8f)
                lineToRelative(5.333f, 4f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(22.05f, 13.293f)
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    -1.415f,
                    1.414f
                )
                arcToRelative(
                    1.83f,
                    1.83f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    0f,
                    2.586f
                )
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    1.415f,
                    1.414f
                )
                arcToRelative(
                    3.829f,
                    3.829f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    0f,
                    -5.413f
                )
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(24.464f, 9.293f)
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -1.413f,
                    1.414f
                )
                arcToRelative(
                    7.483f,
                    7.483f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    0f,
                    10.584f
                )
                arcToRelative(
                    1f,
                    1f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    1.414f,
                    1.414f
                )
                arcToRelative(
                    9.482f,
                    9.482f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    -0.001f,
                    -13.412f
                )
                close()
            }
        }.build()

        return _BluetoothActive!!
    }

@Suppress("ObjectPropertyName")
private var _BluetoothActive: ImageVector? = null
