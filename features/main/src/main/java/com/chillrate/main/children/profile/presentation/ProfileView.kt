package com.chillrate.main.children.profile.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chillrate.foundation.core.Listener
import com.chillrate.main.children.profile.domain.models.ProfileEvent
import com.chillrate.main.children.profile.domain.models.ProfileState

@Composable
fun ProfileView(
    state: ProfileState,
    listener: Listener<ProfileEvent>
) {

    Row {
        Text("")
    }

}