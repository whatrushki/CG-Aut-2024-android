package com.chillrate

import android.app.Application
import com.chillrate.auth.login.di.loginModule
import com.chillrate.auth.register.di.registerModule
import com.chillrate.di.appModule
import com.chillrate.main.children.live.di.liveModule
import com.chillrate.main.children.profile.di.profileModule
import com.chillrate.main.children.room.di.roomModule
import com.chillrate.main.di.mainModule
import com.chillrate.remote.api.di.apiModule
import com.chillrate.remote.callibri.di.callibriModule
import com.chillrate.splash.di.splashModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class ChillRateApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ChillRateApp)
            modules(
                listOf(
                    // App
                    appModule,

                    // Features
                    mainModule,
                    loginModule,
                    registerModule,
                    splashModule,
                    liveModule,
                    profileModule,
                    roomModule,

                    // Callibri
                    apiModule,
                    callibriModule
                )
            )
        }
    }
}