package com.chillrate.remote.api.src

import io.ktor.client.HttpClient
import io.ktor.client.plugins.websocket.DefaultClientWebSocketSession
import io.ktor.client.plugins.websocket.webSocketSession
import io.ktor.client.request.bearerAuth
import io.ktor.websocket.CloseReason
import io.ktor.websocket.close
import kotlinx.serialization.Serializable

class RoomService(
    private val client: HttpClient,
    private val authRepository: AuthRepository
) {
    private var connection: DefaultClientWebSocketSession? = null

    suspend fun connect(roomId: String) {
        val tokens = authRepository.getTokens() ?: return

        connection = client.webSocketSession("wss://${API.DOMAIN}/ws/room/$roomId") {
            bearerAuth(tokens.accessToken)
        }
    }

    suspend fun stop() {
        connection?.close(
            CloseReason(
                CloseReason.Codes.NORMAL,
                "stopped by user"
            )
        )
    }
}

@Serializable
data class Event(
    val type: EventType,
    val data: String
)

enum class EventType {
    JOIN,
    ANALYZE,
    LEAVE
}