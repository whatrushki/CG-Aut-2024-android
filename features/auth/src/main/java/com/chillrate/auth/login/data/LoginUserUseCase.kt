package com.chillrate.auth.login.data

class LoginUserUseCase(
    //private val authService: IAuthService,
    //private val authRepository: IAuthRepository
) {
suspend fun execute(
        username: String,
        password: String,
    ): Result<Unit> = try {
        /*val loginResponse = authService.login(data.toAuthParametersLogin())

        authRepository.setTokens(
            IAuthRepository.AuthTokens(
                accessToken = loginResponse.accessToken,
                refreshToken = loginResponse.refreshToken
            )
        )*/

        Result.success(Unit)
    } catch (e: Exception) {
        Result.failure(e)
    }

}