package com.chillrate.splash.di

import com.chillrate.splash.domain.SplashController
import org.koin.dsl.module

val splashModule = module {
    single<SplashController> { SplashController() }
}