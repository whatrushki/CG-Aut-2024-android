package com.chillrate.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider


@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorPalette = SHUIPalette.blue(darkTheme)

    CompositionLocalProvider(
        LocalSHUIShape provides SHUIShapes.Medium,
        LocalSHUIPalette provides colorPalette,
        LocalSHUITypography provides SHUITypography.Common,
        LocalThemeIsDark provides darkTheme,
        content = content
    )
}