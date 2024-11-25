package com.chillrate.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.chillrate.ui.theme.SHUIIcons

val SHUIIcons.Beacon: ImageVector
    get() {
        if (_Beacon != null) {
            return _Beacon!!
        }
        _Beacon = ImageVector.Builder(
            name = "Beacon",
            defaultWidth = 512.dp,
            defaultHeight = 512.dp,
            viewportWidth = 60f,
            viewportHeight = 60f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(36.62f, 19.87f)
                lineTo(23.38f, 19.87f)
                arcToRelative(7.554f, 7.554f, 0f, isMoreThanHalf = false, isPositiveArc = false, -7.55f, 7.54f)
                verticalLineToRelative(18.42f)
                arcToRelative(14.17f, 14.17f, 0f, isMoreThanHalf = false, isPositiveArc = false, 28.34f, 0f)
                lineTo(44.17f, 27.41f)
                arcToRelative(7.554f, 7.554f, 0f, isMoreThanHalf = false, isPositiveArc = false, -7.55f, -7.54f)
                close()
                moveTo(42.17f, 45.83f)
                arcToRelative(12.17f, 12.17f, 0f, isMoreThanHalf = false, isPositiveArc = true, -24.34f, 0f)
                lineTo(17.83f, 27.41f)
                arcToRelative(5.555f, 5.555f, 0f, isMoreThanHalf = false, isPositiveArc = true, 5.55f, -5.54f)
                horizontalLineToRelative(13.24f)
                arcToRelative(5.555f, 5.555f, 0f, isMoreThanHalf = false, isPositiveArc = true, 5.55f, 5.54f)
                close()
                moveTo(36.354f, 28.799f)
                lineTo(23.646f, 28.799f)
                arcToRelative(2.54f, 2.54f, 0f, isMoreThanHalf = true, isPositiveArc = true, 0f, -5.08f)
                horizontalLineToRelative(12.708f)
                arcToRelative(2.54f, 2.54f, 0f, isMoreThanHalf = true, isPositiveArc = true, 0f, 5.08f)
                close()
                moveTo(23.646f, 25.719f)
                arcToRelative(0.54f, 0.54f, 0f, isMoreThanHalf = true, isPositiveArc = false, 0f, 1.08f)
                horizontalLineToRelative(12.708f)
                arcToRelative(0.54f, 0.54f, 0f, isMoreThanHalf = true, isPositiveArc = false, 0f, -1.08f)
                close()
                moveTo(25.516f, 12.965f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.8f, -1.598f)
                arcToRelative(6.667f, 6.667f, 0f, isMoreThanHalf = false, isPositiveArc = true, 10.557f, -0.183f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, -1.563f, 1.248f)
                arcToRelative(4.667f, 4.667f, 0f, isMoreThanHalf = false, isPositiveArc = false, -7.391f, 0.13f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.803f, 0.403f)
                close()
                moveTo(22.508f, 9.957f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.763f, -1.646f)
                arcToRelative(10.895f, 10.895f, 0f, isMoreThanHalf = false, isPositiveArc = true, 16.5f, -0.167f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, -1.5f, 1.322f)
                arcToRelative(8.895f, 8.895f, 0f, isMoreThanHalf = false, isPositiveArc = false, -13.473f, 0.136f)
                arcToRelative(0.998f, 0.998f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.764f, 0.355f)
                close()
                moveTo(19.355f, 6.803f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.746f, -1.665f)
                arcToRelative(15.344f, 15.344f, 0f, isMoreThanHalf = false, isPositiveArc = true, 22.772f, -0.159f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, -1.474f, 1.352f)
                arcToRelative(13.343f, 13.343f, 0f, isMoreThanHalf = false, isPositiveArc = false, -19.804f, 0.138f)
                arcToRelative(0.998f, 0.998f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.748f, 0.334f)
                close()
                moveTo(30f, 17.362f)
                arcToRelative(2.606f, 2.606f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2.606f, -2.606f)
                arcTo(2.61f, 2.61f, 0f, isMoreThanHalf = false, isPositiveArc = true, 30f, 17.362f)
                close()
                moveTo(30f, 14.149f)
                arcToRelative(0.606f, 0.606f, 0f, isMoreThanHalf = true, isPositiveArc = false, 0.606f, 0.607f)
                arcToRelative(0.607f, 0.607f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.606f, -0.607f)
                close()
                moveTo(31.31f, 42.59f)
                lineTo(35.63f, 38.45f)
                arcToRelative(1.017f, 1.017f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, -1.45f)
                lineToRelative(-4.82f, -4.61f)
                arcToRelative(1.004f, 1.004f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1.69f, 0.73f)
                verticalLineToRelative(7.3f)
                lineToRelative(-3.36f, -3.36f)
                arcToRelative(0.997f, 0.997f, 0f, isMoreThanHalf = true, isPositiveArc = false, -1.41f, 1.41f)
                lineToRelative(4.11f, 4.11f)
                lineToRelative(-4.07f, 4.07f)
                arcToRelative(1.001f, 1.001f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.42f, 1.41f)
                lineToRelative(3.31f, -3.31f)
                verticalLineToRelative(7.3f)
                arcToRelative(1.004f, 1.004f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.61f, 0.92f)
                arcToRelative(1.023f, 1.023f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.08f, -0.2f)
                lineToRelative(4.82f, -4.61f)
                arcToRelative(1.004f, 1.004f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, -1.44f)
                close()
                moveTo(31.12f, 35.46f)
                lineTo(33.5f, 37.72f)
                lineTo(31.12f, 39.99f)
                close()
                moveTo(31.12f, 49.71f)
                verticalLineToRelative(-4.54f)
                lineToRelative(2.38f, 2.27f)
                close()
            }
        }.build()

        return _Beacon!!
    }

@Suppress("ObjectPropertyName")
private var _Beacon: ImageVector? = null
