package com.chillrate.auth.register.di

import com.chillrate.auth.login.domain.RegisterController
import org.koin.dsl.module

val registerModule = module {
    single<RegisterController> { RegisterController() }
}