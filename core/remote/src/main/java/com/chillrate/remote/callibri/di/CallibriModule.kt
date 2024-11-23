package com.chillrate.remote.callibri.di

import com.chillrate.remote.callibri.src.CallibriController
import com.chillrate.remote.callibri.src.CallibriRepository
import org.koin.dsl.module

val callibriModule = module {
    single<CallibriController> { CallibriController() }
    single<CallibriRepository> { CallibriRepository(get()) }
}