package com.chillrate.main.children.profile.domain.models

data class ProfileState(
    val profileData: ProfileData? = null,
    val profileDataFetchState: ProfileFetchState = ProfileFetchState.Idle,
    val destination: ProfileDestination = ProfileDestination.None,
    val username: String = "",
    val password: String = "",
    val email: String = "",
    val realName: String = ""
)

sealed interface ProfileDestination {
    data object None : ProfileDestination
    data object Login : ProfileDestination
    data object Register : ProfileDestination
}

data class ProfileData(val fullName: String)

sealed interface ProfileFetchState {
    data object Idle : ProfileFetchState
    data object InProcess : ProfileFetchState
    data object Success : ProfileFetchState
    data class Error(
        val message: String? = null
    ) : ProfileFetchState

    data object NotAuthorized : ProfileFetchState
}