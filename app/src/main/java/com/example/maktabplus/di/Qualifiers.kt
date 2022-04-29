package com.example.maktabplus.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
@MustBeDocumented
annotation class LoggingInterceptor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IRemoteDataSource