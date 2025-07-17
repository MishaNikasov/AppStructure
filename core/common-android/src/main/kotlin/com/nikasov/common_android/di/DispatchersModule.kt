package com.nikasov.common_android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import kotlin.annotation.AnnotationTarget.FIELD
import kotlin.annotation.AnnotationTarget.FUNCTION
import kotlin.annotation.AnnotationTarget.VALUE_PARAMETER

@Qualifier
@Retention
@Target(FIELD, VALUE_PARAMETER, FUNCTION)
annotation class IODispatcher

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatchersModule {
    @Provides
    @IODispatcher
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}