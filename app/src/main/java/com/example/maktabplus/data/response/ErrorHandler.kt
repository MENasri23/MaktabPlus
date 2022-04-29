package com.example.maktabplus.data.response

import okhttp3.ResponseBody
import org.json.JSONObject
import java.io.IOException
import java.net.SocketTimeoutException

private typealias Code = ApiError.StatusCode


interface ErrorHandler<T> {
    fun handle(error: Error<T>): ApiError
}


class RetrofitErrorHandler : ErrorHandler<ResponseBody?> {

    override fun handle(error: Error<ResponseBody?>): ApiError {
        val statusCode = error.code

        return with(Code) {
            when (statusCode) {
                BAD_REQUEST -> ApiError.BadRequest
                NOT_FOUND -> ApiError.NotFound
                FORBIDDEN -> ApiError.Forbidden
                REQUEST_TIMEOUT -> ApiError.RequestTimeout
                VERIFY_OTP_FAILED -> ApiError.VerifyOtpFailed
                else -> {
                    val errorJsonObject = asJSONObject(error.body)
                    errorJsonObject?.let { body ->
                        // handle error body
                        ApiError.Unknown()
                    } ?: ApiError.Unknown()
                }
            }
        }
    }

    private fun asJSONObject(body: ResponseBody?) = body?.let {
        JSONObject(it.string())
    }
}

class ExceptionErrorHandler : ErrorHandler<Throwable?> {

    override fun handle(error: Error<Throwable?>): ApiError {
        return when (val exception = error.body) {
            is SocketTimeoutException -> ApiError.RequestTimeout
            is IOException -> ApiError.Internal
            else -> ApiError.Unknown(exception)
        }
    }
}