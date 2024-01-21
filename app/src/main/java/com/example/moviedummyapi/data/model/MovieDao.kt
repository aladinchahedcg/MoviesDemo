package com.example.moviedummyapi.data.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(moviesList: List<MovieEntity>)

    @Query("SELECT * FROM my_data_items")
    fun getAllMovies(): Flow<List<MovieEntity>>
}
