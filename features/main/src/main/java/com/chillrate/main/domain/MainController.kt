package com.chillrate.main.domain

import com.chillrate.foundation.core.UIController
import com.chillrate.main.children.profile.domain.models.ProfileAction
import com.chillrate.main.children.profile.domain.models.ProfileEvent
import com.chillrate.main.children.profile.domain.models.ProfileState

class MainController : UIController<ProfileState, ProfileAction, ProfileEvent>(
    ProfileState()
) {
    override fun obtainEvent(viewEvent: ProfileEvent) = when (viewEvent) {
        ProfileEvent.Init -> {}
        else -> {}
    }
}