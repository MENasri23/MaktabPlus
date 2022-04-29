package com.example.maktabplus.data.response

sealed class ApiError {

    class Unknown(val throwable: Throwable? = null) : ApiError()

    class BadResponseCode(val responseCode: Int) : ApiError()

    object Parse : ApiError()

    object NoConnection : ApiError()

    object RefreshTokenFailed : ApiError()

    object NoContent : ApiError()

    object Internal : ApiError()

    object VerifyOtpFailed : ApiError()
    object NotFound : ApiError()
    object Forbidden : ApiError()
    object BadRequest : ApiError()
    object RequestTimeout : ApiError()
    class Global<T>(globalError: Error<T>) : ApiError()

    object StatusCode {
        const val BAD_REQUEST = 400
        const val FORBIDDEN = 403
        const val NOT_FOUND = 404
        const val REQUEST_TIMEOUT = 408
        const val CONFLICT = 409
        const val VERIFY_OTP_FAILED = 1000
    }


}