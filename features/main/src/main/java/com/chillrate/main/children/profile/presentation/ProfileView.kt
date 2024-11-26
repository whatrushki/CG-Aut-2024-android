package com.chillrate.main.children.profile.presentation

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
import com.chillrate.main.children.profile.domain.models.ProfileEvent
import com.chillrate.main.children.profile.domain.models.ProfileState
import com.chillrate.ui.components.spacer.Space
import com.chillrate.ui.icons.Note
import com.chillrate.ui.theme.SHUIIcons
import com.chillrate.ui.theme.SHUITheme.palettes
import com.chillrate.ui.theme.SHUITheme.spacing
import com.chillrate.ui.theme.SHUITheme.typography

@Composable
fun ProfileView(
    state: ProfileState,
    listener: Listener<ProfileEvent>
) = Box(
    contentAlignment = Alignment.Center,
    modifier = Modifier.fillMaxSize()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(200.dp)
    ) {
        Image(
            imageVector = SHUIIcons.Note,
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
/*when (state.profileDataFetchState) {
    ProfileFetchState.NotAuthorized -> {
        Text("notAuthorized")

        Button(
            onClick = {
                listener(ProfileEvent.OnLoginClicked)
            }
        ) {
            Text("Login")
        }

        Button(
            onClick = {
                listener(ProfileEvent.OnRegisterClicked)
            }
        ) {
            Text("Register")
        }
    }

    ProfileFetchState.InProcess -> {
        Text("InProcess")
    }

    ProfileFetchState.Success -> {
        Text(state.profileData?.fullName.toString())
    }

    ProfileFetchState.Idle -> {
        Text("Idle")
    }

    is ProfileFetchState.Error -> Text(state.profileDataFetchState.message.toString())
}*/