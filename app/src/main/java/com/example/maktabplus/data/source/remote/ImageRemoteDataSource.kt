package com.example.maktabplus.data.source.remote

import com.example.maktabplus.data.model.Image
import retrofit2.Response

interface ImageRemoteDataSource {

     suspend fun fetch(): Response<List<Image>>
}