package com.example.maktabplus.data.repository

import Resource
import com.example.maktabplus.data.model.Image
import com.example.maktabplus.data.source.remote.ImageRemoteDataSource
import com.example.maktabplus.data.source.remote.ImageRemoteDataSourceImpl
import com.example.maktabplus.di.IRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton


class ImageRepository @Inject constructor(
    @IRemoteDataSource
    private val remoteDataSource: ImageRemoteDataSource
) {

    fun getImageList(): Flow<Resource<List<Image>>> = flow {
        remoteDataSource.fetch()
    }

}
