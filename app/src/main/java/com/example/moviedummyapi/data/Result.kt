package com.example.moviedummyapi.data

import kotlin.Result

sealed class Result<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?): com.example.moviedummyapi.data.Result<T>(data)
    class Error<T> (data: T? = null, message: String): com.example.moviedummyapi.data.Result<T>(data, message)

}