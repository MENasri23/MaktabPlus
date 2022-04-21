package com.example.maktabplus.data.source.remote

import com.example.maktabplus.data.model.Image
import com.example.maktabplus.data.source.remote.api.PictureSumApi
import retrofit2.Response

class ImageRemoteDataSource(
    private val pictureSumApi: PictureSumApi
) : RemoteDataSource<Response<List<Image>>> {

    override suspend fun fetch(): Response<List<Image>> {
        return pictureSumApi.getImageList()
    }
}