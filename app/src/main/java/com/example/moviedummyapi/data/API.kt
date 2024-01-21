package com.example.moviedummyapi.data

import com.example.moviedummyapi.data.model.MyDataItem
import com.example.moviedummyapi.data.model.MyDataItemRoom
import retrofit2.http.GET

interface API {
    @GET("movies")
    suspend fun getMovieList(): List<MyDataItem>
    suspend fun getMovieListRoom(): List<MyDataItemRoom>


    companion object {
        const val BASE_URL =
            "https://my-json-server.typicode.com/horizon-code-academy/fake-movies-api/"
    }
}