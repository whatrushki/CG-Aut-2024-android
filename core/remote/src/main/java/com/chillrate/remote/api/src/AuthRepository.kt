package com.chillrate.remote.api.src

import android.content.Context
import androidx.datastore.core.Serializer
import com.chillrate.foundation.data.Store
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

@Serializable
data class AuthTokens(
    val accessToken: String,
    val refreshToken: String
)

class AuthRepository(
    context: Context
) : Store<AuthTokens>(
    context = context, fileName = "auth_tokens.json", serializer = AppConfigSerializer
) {
    object AppConfigSerializer : Serializer<AuthTokens> {
        override val defaultValue: AuthTokens
            get() = AuthTokens("", "")

        override suspend fun readFrom(input: InputStream): AuthTokens = try {
            Json.decodeFromString(
                deserializer = AuthTokens.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: Exception) {
            println(e.stackTrace)
            defaultValue
        }

        override suspend fun writeTo(t: AuthTokens, output: OutputStream) =
            withContext(Dispatchers.IO) {
                output.write(
                    Json.encodeToString(
                        serializer = AuthTokens.serializer(), value = t
                    ).encodeToByteArray()
                )
            }
    }

    suspend fun setTokens(tokens: AuthTokens) = saveData(tokens)

    suspend fun getTokens(): AuthTokens? {
        val data = getData()
        return if (data != null && data.accessToken.isNotEmpty()) data else null
    }
}