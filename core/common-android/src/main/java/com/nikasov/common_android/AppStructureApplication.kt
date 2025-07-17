package com.nikasov.common_android

import android.app.Application
import com.nikasov.common.logger.Logger
import com.nikasov.common_android.logger.AndroidLogger
import timber.log.Timber

abstract class AppStructureApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Logger.set(AndroidLogger())
    }
}