package com.nikasov.common_android

import android.app.Application
import timber.log.Timber

abstract class AppStructureApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}