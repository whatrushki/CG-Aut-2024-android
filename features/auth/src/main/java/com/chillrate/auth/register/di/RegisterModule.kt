package com.chillrate.auth.register.di

import com.chillrate.auth.register.domain.RegisterController
import org.koin.dsl.module

val registerModule = module {
    single<RegisterController> { RegisterController() }
}