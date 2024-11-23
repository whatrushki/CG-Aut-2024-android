package com.chillrate.main.di

import com.chillrate.main.children.profile.domain.ProfileController
import org.koin.dsl.module

val mainModule = module {
    single<ProfileController> { ProfileController() }
}