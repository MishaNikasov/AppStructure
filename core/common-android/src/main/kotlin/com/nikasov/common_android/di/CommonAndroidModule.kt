package com.nikasov.common_android.di

import com.nikasov.common.logger.Logger
import com.nikasov.common.resources.StringResources
import com.nikasov.common_android.logger.AndroidLogger
import com.nikasov.common_android.resources.AndroidStringResources
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CommonAndroidModule {
    @Binds
    abstract fun bindLogger(logger: AndroidLogger): Logger

    @Binds
    abstract fun bindLogger(logger: AndroidStringResources): StringResources
}