package com.chillrate.main.children.profile.domain

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.chillrate.foundation.core.UIController
import com.chillrate.foundation.utils.safeExecute
import com.chillrate.foundation.utils.suspendCall
import com.chillrate.main.children.profile.domain.models.ProfileAction
import com.chillrate.main.children.profile.domain.models.ProfileData
import com.chillrate.main.children.profile.domain.models.ProfileDestination
import com.chillrate.main.children.profile.domain.models.ProfileEvent
import com.chillrate.main.children.profile.domain.models.ProfileFetchState
import com.chillrate.main.children.profile.domain.models.ProfileState
import com.chillrate.remote.api.src.AuthRepository
import com.chillrate.remote.api.src.AuthService
import com.chillrate.remote.api.src.AuthTokens
import com.chillrate.remote.api.src.LoginRequest
import com.chillrate.remote.api.src.SignUpRequest
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.delay

class ProfileController(
    private val authService: AuthService,
    private val authRepository: AuthRepository
) : UIController<ProfileState, ProfileAction, ProfileEvent>(
    ProfileState()
) {
    override fun obtainEvent(viewEvent: ProfileEvent) {
        when (viewEvent) {
            ProfileEvent.Init -> init()
            ProfileEvent.OnLoginClicked ->
                suspendCall(viewModelScope) {
                    updateState { copy(destination = ProfileDestination.None) }
                    delay(600L)
                    updateState { copy(destination = ProfileDestination.Login) }
                }


            ProfileEvent.OnRegisterClicked ->
                suspendCall(viewModelScope) {
                    updateState { copy(destination = ProfileDestination.None) }
                    delay(600L)
                    updateState { copy(destination = ProfileDestination.Register) }
                }


            is ProfileEvent.OnFocusTakenOffOnLogin ->
                updateState {
                    copy(
                        username = viewEvent.username,
                        password = viewEvent.password
                    )
                }

            is ProfileEvent.OnFocusTakenOffOnRegister -> updateState {
                copy(
                    username = viewEvent.username,
                    password = viewEvent.password,
                    email = viewEvent.email,
                    realName = viewEvent.fullName
                )
            }

            ProfileEvent.OnSubmitLoginClicked -> login()
            ProfileEvent.OnSubmitRegisterClicked -> register()
        }
    }

    fun register() {
        safeExecute(
            scope = viewModelScope,
            block = {
                val registerResponse = authService.signup(
                    SignUpRequest(
                        realname = viewState.realName,
                        username = viewState.username,
                        email = viewState.email,
                        password = viewState.password
                    )
                )

                if (registerResponse.status.value != 200) {
                    Log.d("d", registerResponse.call.response.bodyAsText())
                    return@safeExecute
                }

                val loginResponse = authService.login(
                    LoginRequest(
                        username = viewState.username,
                        password = viewState.password
                    )
                )

                authRepository.setTokens(
                    AuthTokens(loginResponse.accessToken, "")
                )

                safeUpdateState {
                    copy(
                        profileDataFetchState = ProfileFetchState.Success,
                        profileData = ProfileData(fullName = viewState.realName),
                        destination = ProfileDestination.None
                    )
                }
            }
        ) {
            Log.d("d", it.message.toString())
        }
    }

    fun login() {
        safeExecute(
            scope = viewModelScope,
            block = {
                val loginResponse = authService.login(
                    LoginRequest(
                        username = viewState.username,
                        password = viewState.password
                    )
                )

                authRepository.setTokens(
                    AuthTokens(loginResponse.accessToken, "")
                )

                safeUpdateState {
                    copy(
                        profileDataFetchState = ProfileFetchState.InProcess,
                        destination = ProfileDestination.None
                    )
                }

                val profile = authService.profile()

                safeUpdateState {
                    copy(
                        profileDataFetchState = ProfileFetchState.Success,
                        profileData = ProfileData(fullName = profile.realname)
                    )
                }
            }
        ) {
            Log.d("d", it.message.toString())
        }
    }

    fun init() {
        safeExecute(
            scope = viewModelScope,
            block = {
                Log.d("d", "init")
                val authorized = authRepository.getTokens() != null
                if (authorized) {
                    val profile = authService.profile()
                    safeUpdateState {
                        copy(
                            profileData = ProfileData(fullName = profile.realname),
                            profileDataFetchState = ProfileFetchState.Success
                        )
                    }
                } else {
                    safeUpdateState {
                        copy(
                            profileDataFetchState = ProfileFetchState.NotAuthorized
                        )
                    }
                }
            }
        ) {
            Log.d("d", it.message.toString())
            safeUpdateState {
                copy(profileDataFetchState = ProfileFetchState.Error(it.message))
            }
        }
    }
}