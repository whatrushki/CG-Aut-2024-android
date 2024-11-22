package com.chillrate.main.di

import com.chillrate.main.domain.MainController
import org.koin.dsl.module

val mainModule = module {
    single<MainController> { MainController() }
}