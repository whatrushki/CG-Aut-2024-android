package com.chillrate.main.children.room.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chillrate.foundation.core.Listener
import com.chillrate.main.children.room.domain.models.RoomEvent
import com.chillrate.main.children.room.domain.models.RoomState
import com.chillrate.ui.components.spacer.Space
import com.chillrate.ui.icons.Report
import com.chillrate.ui.theme.SHUIIcons
import com.chillrate.ui.theme.SHUITheme.palettes
import com.chillrate.ui.theme.SHUITheme.spacing
import com.chillrate.ui.theme.SHUITheme.typography

@Composable
fun RoomView(
    state: RoomState,
    listener: Listener<RoomEvent>
) = Box(
    contentAlignment = Alignment.Center,
    modifier = Modifier.fillMaxSize()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(200.dp)
    ) {
        Image(
            imageVector = SHUIIcons.Report,
            contentDescription = ""
        )

        Space(spacing.md)

        Text(
            "Приходите позже",
            style = typography.bodyMedium,
            color = palettes.foreground,
            textAlign = TextAlign.Center
        )
    }
}