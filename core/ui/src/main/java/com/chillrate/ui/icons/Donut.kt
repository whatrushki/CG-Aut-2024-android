package com.chillrate.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.chillrate.ui.theme.SHUIIcons

val SHUIIcons.Donut: ImageVector
    get() {
        if (_Donut != null) {
            return _Donut!!
        }
        _Donut = ImageVector.Builder(
            name = "Donut",
            defaultWidth = 512.dp,
            defaultHeight = 512.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(8f, 0f)
                curveTo(3.589f, 0f, 0f, 3.589f, 0f, 8f)
                reflectiveCurveToRelative(3.589f, 8f, 8f, 8f)
                reflectiveCurveToRelative(8f, -3.589f, 8f, -8f)
                reflectiveCurveToRelative(-3.589f, -8f, -8f, -8f)
                close()
                moveTo(14.975f, 7.5f)
                horizontalLineToRelative(-3.026f)
                arcTo(
                    3.981f,
                    3.981f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    8.5f,
                    4.05f
                )
                lineTo(8.5f, 1.026f)
                arcTo(7f, 7f, 0f, isMoreThanHalf = false, isPositiveArc = true, 14.975f, 7.5f)
                close()
                moveTo(8f, 11f)
                curveToRelative(-1.654f, 0f, -3f, -1.346f, -3f, -3f)
                reflectiveCurveToRelative(1.346f, -3f, 3f, -3f)
                reflectiveCurveToRelative(3f, 1.346f, 3f, 3f)
                reflectiveCurveToRelative(-1.346f, 3f, -3f, 3f)
                close()
                moveTo(1f, 8f)
                curveToRelative(0f, -3.691f, 2.874f, -6.716f, 6.5f, -6.975f)
                verticalLineToRelative(3.026f)
                curveTo(5.532f, 4.3f, 4f, 5.966f, 4f, 8f)
                curveToRelative(0f, 2.206f, 1.794f, 4f, 4f, 4f)
                arcToRelative(
                    3.96f,
                    3.96f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    2.44f,
                    -0.853f
                )
                lineToRelative(2.137f, 2.137f)
                arcTo(6.964f, 6.964f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8f, 15f)
                curveToRelative(-3.86f, 0f, -7f, -3.14f, -7f, -7f)
                close()
                moveTo(13.284f, 12.577f)
                lineTo(11.147f, 10.44f)
                curveToRelative(0.429f, -0.552f, 0.71f, -1.213f, 0.802f, -1.94f)
                horizontalLineToRelative(3.026f)
                arcToRelative(
                    6.962f,
                    6.962f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    -1.69f,
                    4.077f
                )
                close()
            }
        }.build()

        return _Donut!!
    }

@Suppress("ObjectPropertyName")
private var _Donut: ImageVector? = null
