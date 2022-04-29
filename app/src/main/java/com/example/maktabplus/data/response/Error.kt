package com.example.maktabplus.data.response

data class Error<T : Any?>(
    val code: Int = NO_CODE,
    val body: T? = null
) {

    companion object {
        const val NO_CODE = -1
    }
}


