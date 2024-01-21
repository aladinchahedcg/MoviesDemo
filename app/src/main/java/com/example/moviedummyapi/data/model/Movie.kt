package com.example.moviedummyapi.data.model

data class MovieJson(
    val Poster: String?,
    val Runtime: String,
    val Title: String,
    val Year: String
)

data class Movie(

    val poster: String,
    val runtime: String,
    val title: String,
    val year: String
)

fun MovieJson.toMovie() = Movie(
    poster = Poster ?: "",
    runtime = Runtime,
    title = Title,
    year = Year,
)

fun MovieEntity.toMovie() = Movie(
    poster = poster,
    runtime = runtime,
    title = title,
    year = year,
)

fun List<MovieEntity>.toMovie() = this.map {
    it.toMovie()
}