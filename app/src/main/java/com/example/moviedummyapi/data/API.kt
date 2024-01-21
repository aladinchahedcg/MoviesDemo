package com.example.moviedummyapi.data

import com.example.moviedummyapi.data.model.MovieEntity
import com.example.moviedummyapi.data.model.MovieJson
import retrofit2.http.GET

interface API {
    @GET("movies")
    suspend fun getMovieList(): List<MovieJson>
    suspend fun getMovieListRoom(): List<MovieEntity>


    companion object {
        const val BASE_URL =
            "https://my-json-server.typicode.com/horizon-code-academy/fake-movies-api/"
    }
}