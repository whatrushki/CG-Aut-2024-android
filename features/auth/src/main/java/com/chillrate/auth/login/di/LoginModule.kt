package com.chillrate.auth.login.di

import com.chillrate.auth.login.domain.LoginController
import org.koin.dsl.module

val loginModule = module {
    single<LoginController> { LoginController() }
}