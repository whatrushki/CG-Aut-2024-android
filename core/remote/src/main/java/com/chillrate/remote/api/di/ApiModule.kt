package com.chillrate.remote.api.di

import com.chillrate.remote.api.src.AuthService
import com.chillrate.remote.api.src.RoomService
import org.koin.dsl.module

val apiModule = module {
    single { RoomService(get()) }
    single { AuthService(get()) }
}