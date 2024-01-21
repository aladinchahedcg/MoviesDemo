package com.example.moviedummyapi.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


fun Movie.toMovieEntity() = MovieEntity(
    poster = poster,
    runtime = runtime,
    title = title,
    year = year,
)

@Entity(tableName = "my_data_items")
data class MovieEntity(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val poster: String,
    val runtime: String,
    val title: String,
    val year: String
)

