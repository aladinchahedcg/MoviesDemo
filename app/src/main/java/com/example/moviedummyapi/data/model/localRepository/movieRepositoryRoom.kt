package com.example.moviedummyapi.data.model.localRepository

import com.example.moviedummyapi.data.model.MyDataItemRoom
import kotlinx.coroutines.flow.Flow

interface MovieRepositoryRoom {

    suspend fun getMoviesListRoom(): Flow<List<MyDataItemRoom>>

}