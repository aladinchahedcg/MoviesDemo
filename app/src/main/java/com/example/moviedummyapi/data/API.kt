package com.example.moviedummyapi.data

import com.example.moviedummyapi.data.model.MyDataItem
import retrofit2.http.GET

interface API {
    @GET("movies")
    suspend fun getMovieList(): List<MyDataItem>

    companion object {
        const val BASE_URL =
            "https://my-json-server.typicode.com/horizon-code-academy/fake-movies-api/"
    }
}