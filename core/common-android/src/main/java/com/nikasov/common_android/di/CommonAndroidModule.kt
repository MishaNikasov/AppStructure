package com.nikasov.common_android.di

import com.nikasov.common.logger.Logger
import com.nikasov.common_android.logger.AndroidLogger
import dagger.Binds
import dagger.Module

@Module
abstract class CommonAndroidModule {
    @Binds
    abstract fun bindLogger(logger: AndroidLogger): Logger
}