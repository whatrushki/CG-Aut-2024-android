package com.chillrate.ui.components.avatar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.chillrate.ui.components.styled_box.StyledBox
import com.chillrate.ui.theme.SHUIShapes
import com.chillrate.ui.theme.SHUITheme.palettes
import com.chillrate.ui.theme.SHUITheme.typography
import coil3.compose.SubcomposeAsyncImage

@Composable
fun Avatar(
    icon: String,
    fallback: String
) = Avatar {
    val placeholder: @Composable () -> Unit = remember {
        {
            StyledBox(
                modifier = Modifier.fillMaxSize(),
                shape = SHUIShapes.Circle
            ) {
                Text(
                    text = fallback.uppercase(),
                    style = typography.lead,
                    color = palettes.foreground
                )
            }
        }
    }

    SubcomposeAsyncImage(
        model = icon,
        contentDescription = "$fallback's avatar",
        loading = { placeholder() },
        error = { placeholder() },
    )
}