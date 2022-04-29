package com.example.maktabplus.data.source.remote

import com.example.maktabplus.data.model.Image
import com.example.maktabplus.data.source.remote.api.PictureSumApi
import retrofit2.Response
import javax.inject.Inject


class ImageRemoteDataSourceImpl @Inject constructor(
    private val pictureSumApi: PictureSumApi
) : ImageRemoteDataSource {

    override suspend fun fetch(): Response<List<Image>> {
        return pictureSumApi.getImageList()
    }
}