package com.chillrate.main.children.profile.domain.models

sealed interface ProfileEvent {
    data object Init : ProfileEvent
}