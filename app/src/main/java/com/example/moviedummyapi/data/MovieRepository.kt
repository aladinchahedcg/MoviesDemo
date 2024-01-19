package com.example.moviedummyapi.data

import com.example.moviedummyapi.data.model.MyDataItem
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovieList(): Flow<Result<List<MyDataItem>>>
}