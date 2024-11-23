package com.chillrate.main.children.live.di

import com.chillrate.main.children.live.domain.LiveController
import com.chillrate.main.children.room.domain.RoomController
import org.koin.dsl.module

val liveModule = module {
    single<LiveController> { LiveController(get()) }
}