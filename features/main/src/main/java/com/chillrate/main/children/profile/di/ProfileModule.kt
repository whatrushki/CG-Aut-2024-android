package com.chillrate.main.children.profile.di

import com.chillrate.main.children.profile.domain.ProfileController
import org.koin.dsl.module

val profileModule = module {
    single<ProfileController> { ProfileController() }
}