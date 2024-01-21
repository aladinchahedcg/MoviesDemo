package com.example.moviedummyapi.data.model.remoteRepository

import com.example.moviedummyapi.data.Result
import com.example.moviedummyapi.data.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovieList(): Flow<Result<List<Movie>>>

}