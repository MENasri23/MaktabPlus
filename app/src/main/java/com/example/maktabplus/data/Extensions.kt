package com.example.maktabplus.data

import Resource
import com.example.maktabplus.data.response.ApiError
import com.example.maktabplus.util.emitApiError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

inline fun <T> safeApiCall(
    crossinline apiCall: suspend () -> Response<T>
): Flow<Resource<T>> {
    return flow {
        emit(Resource.loading())
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                val resource = if (body != null && response.code() == 200) Resource.success(body)
                    else Resource.error(ApiError.NoContent)
                emit(resource)
            } else {
                emitApiError(
                    statusCode = response.code(),
                    errorBody = response.errorBody()
                )
            }
        } catch (t: Exception) {
            emitApiError(t)
        }
    }
}