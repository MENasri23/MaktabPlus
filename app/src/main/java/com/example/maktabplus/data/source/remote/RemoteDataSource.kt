package com.example.maktabplus.data.source.remote

interface RemoteDataSource<out T> {

    suspend fun fetch(): T
}