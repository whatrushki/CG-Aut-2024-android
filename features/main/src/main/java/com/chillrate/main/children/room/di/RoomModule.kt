package com.chillrate.main.children.room.di

import com.chillrate.main.children.room.domain.RoomController
import org.koin.dsl.module

val roomModule = module {
    single<RoomController> { RoomController(get()) }
}