package com.example.maktabplus.util

import Resource
import com.example.maktabplus.data.response.*
import kotlinx.coroutines.flow.*
import okhttp3.ResponseBody

fun <T> Flow<T>.toResource(): Flow<Resource<T>> = flow {
    map {
        Resource.success(it)
    }.onStart {
        emit(Resource.loading())
    }.catch { cause ->
        emitApiError(cause)
    }
}

suspend inline fun <T> FlowCollector<Resource<T>>.emitApiError(
    statusCode: Int,
    errorBody: ResponseBody?
) {
    emitApiError(Error(statusCode, errorBody)) {
        RetrofitErrorHandler().handle(it)
    }
}

suspend inline fun <T> FlowCollector<Resource<T>>.emitApiError(
    exception: Throwable,
) {
    emitApiError(Error(body = exception)) {
        ExceptionErrorHandler().handle(it)
    }
}

suspend inline fun <T, V : Any?> FlowCollector<Resource<T>>.emitApiError(
    error: Error<V?>,
    crossinline handle: (Error<V?>) -> ApiError
) {
    emit(Resource.error(handle(error)))
}