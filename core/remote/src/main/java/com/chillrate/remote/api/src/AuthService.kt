package com.chillrate.remote.api.src

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class AuthService(
    private val client: HttpClient
) {
    suspend fun signup(
        data: SignUpRequest
    ) = client.post("${API.BASE_URL}/signup") {
        contentType(ContentType.Application.Json)
        setBody(data)
    }

    suspend fun login(
        data: LoginRequest
    ): LoginResponse = client.post("${API.BASE_URL}/login") {
        contentType(ContentType.Application.Json)
        setBody(data)
    }.body()
}

@Serializable
data class SignUpRequest(
    val realname: String,
    val username: String,
    val email: String,
    val password: String
)


@Serializable
data class LoginRequest(
    val username: String,
    val password: String
)

@Serializable
data class LoginResponse(
    @SerialName("access_token") val accessToken: String,
    @SerialName("token_type") val tokenType: String,
    @SerialName("realname") val realName: String
)

