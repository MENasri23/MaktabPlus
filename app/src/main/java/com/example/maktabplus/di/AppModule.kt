package com.example.maktabplus.di

import com.example.maktabplus.data.source.remote.ImageRemoteDataSourceImpl
import com.example.maktabplus.data.source.remote.ImageRemoteDataSource
import com.example.maktabplus.data.source.remote.api.PictureSumApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @IRemoteDataSource
    @Provides
    fun provideImageRemoteDataSource(
        pictureSumApi: PictureSumApi
    ): ImageRemoteDataSource =
        ImageRemoteDataSourceImpl(pictureSumApi)

}*/
