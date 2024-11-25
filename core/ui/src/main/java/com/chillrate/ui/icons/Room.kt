package com.chillrate.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.chillrate.ui.theme.SHUIIcons

val SHUIIcons.Room: ImageVector
    get() {
        if (_Room != null) {
            return _Room!!
        }
        _Room = ImageVector.Builder(
            name = "Room",
            defaultWidth = 512.dp,
            defaultHeight = 512.dp,
            viewportWidth = 480f,
            viewportHeight = 480f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(91f, 441.5f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, -8f, 8f)
                lineTo(8f, 449.5f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, -16f)
                horizontalLineToRelative(75f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8f, 8f)
                close()
                moveTo(186f, 88.5f)
                curveToRelative(30.88f, 0f, 56f, 25.12f, 56f, 56f)
                verticalLineToRelative(14f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, -8f, 8f)
                horizontalLineToRelative(-96f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, -8f, -8f)
                verticalLineToRelative(-14f)
                curveToRelative(0f, -30.88f, 25.12f, -56f, 56f, -56f)
                close()
                moveTo(146f, 144.5f)
                verticalLineToRelative(6f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(-6f)
                curveToRelative(0f, -22.06f, -17.94f, -40f, -40f, -40f)
                reflectiveCurveToRelative(-40f, 17.94f, -40f, 40f)
                close()
                moveTo(66.5f, 417.5f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 8f, -8.01f)
                lineToRelative(-0.42f, -312.67f)
                curveTo(74.04f, 69.02f, 96.53f, 46.5f, 124.33f, 46.5f)
                horizontalLineToRelative(3.43f)
                curveToRelative(16.04f, 0f, 30.74f, 7.39f, 40.33f, 20.27f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 12.83f, -9.55f)
                curveToRelative(-12.46f, -16.73f, -32.33f, -26.72f, -53.17f, -26.72f)
                horizontalLineToRelative(-3.43f)
                curveToRelative(-36.65f, 0f, -66.3f, 29.68f, -66.25f, 66.33f)
                lineToRelative(0.42f, 312.67f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 8f, 7.99f)
                close()
                moveTo(444f, 308.5f)
                verticalLineToRelative(-52.16f)
                curveToRelative(0f, -23.62f, -19.22f, -42.84f, -42.84f, -42.84f)
                lineTo(182.84f, 213.5f)
                curveToRelative(-23.62f, 0f, -42.84f, 19.22f, -42.84f, 42.84f)
                lineTo(140f, 275.5f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 16f, 0f)
                verticalLineToRelative(-19.16f)
                curveToRelative(0f, -14.8f, 12.04f, -26.84f, 26.84f, -26.84f)
                lineTo(285f, 229.5f)
                verticalLineToRelative(90f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 16f, 0f)
                verticalLineToRelative(-90f)
                horizontalLineToRelative(100.16f)
                curveToRelative(14.8f, 0f, 26.84f, 12.04f, 26.84f, 26.84f)
                verticalLineToRelative(52.38f)
                curveToRelative(-17.97f, 1.94f, -32f, 17.19f, -32f, 35.66f)
                verticalLineToRelative(7.13f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 16f, 0f)
                verticalLineToRelative(-7.13f)
                curveToRelative(0f, -10.96f, 8.91f, -19.87f, 19.87f, -19.87f)
                horizontalLineToRelative(12.26f)
                curveToRelative(10.96f, 0f, 19.87f, 8.91f, 19.87f, 19.87f)
                verticalLineToRelative(69.26f)
                curveToRelative(0f, 10.96f, -8.91f, 19.87f, -19.87f, 19.87f)
                lineTo(412f, 433.5f)
                curveToRelative(0f, -52.36f, 0.04f, -49.14f, -0.07f, -50f)
                curveToRelative(0.61f, -4.89f, -3.21f, -9f, -7.93f, -9f)
                lineTo(225f, 374.5f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, 16f)
                horizontalLineToRelative(171f)
                verticalLineToRelative(51f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 8f, 8f)
                horizontalLineToRelative(40.13f)
                curveToRelative(19.78f, 0f, 35.87f, -16.09f, 35.87f, -35.87f)
                lineTo(480f, 344.37f)
                curveToRelative(0f, -19.52f, -15.78f, -35.87f, -36f, -35.87f)
                close()
                moveTo(363f, 433.5f)
                lineTo(141.87f, 433.5f)
                curveToRelative(-10.96f, 0f, -19.87f, -8.91f, -19.87f, -19.87f)
                verticalLineToRelative(-69.26f)
                curveToRelative(0f, -10.96f, 8.91f, -19.87f, 19.87f, -19.87f)
                horizontalLineToRelative(12.26f)
                curveToRelative(10.96f, 0f, 19.87f, 8.91f, 19.87f, 19.87f)
                verticalLineToRelative(45.13f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 16f, 0f)
                verticalLineToRelative(-45.13f)
                curveToRelative(0f, -19.78f, -16.09f, -35.87f, -35.87f, -35.87f)
                lineTo(141.87f, 308.5f)
                curveToRelative(-19.78f, 0f, -35.87f, 16.09f, -35.87f, 35.87f)
                verticalLineToRelative(69.26f)
                curveToRelative(0f, 19.78f, 16.09f, 35.87f, 35.87f, 35.87f)
                lineTo(363f, 449.5f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, -16f)
                close()
            }
        }.build()

        return _Room!!
    }

@Suppress("ObjectPropertyName")
private var _Room: ImageVector? = null
