package com.example.maktabplus.data.source.remote.api

import com.example.maktabplus.data.model.Image
import retrofit2.Response
import retrofit2.http.GET

interface PictureSumApi {

    @GET("v2/list")
    suspend fun getImageList(): Response<List<Image>>
}