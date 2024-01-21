package com.example.moviedummyapi.data.model.remoteRepository

import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.moviedummyapi.data.API
import com.example.moviedummyapi.data.Result
import com.example.moviedummyapi.data.model.Movie
import com.example.moviedummyapi.data.model.MovieDao
import com.example.moviedummyapi.data.model.toMovie
import com.example.moviedummyapi.data.model.toMovieEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: API,
    private val movieDao: MovieDao

) : MovieRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getMovieList(): Flow<Result<List<Movie>>> = withContext(Dispatchers.IO) {
        flow {
            val moviesFromApi = try {
                val remoteMovies = api.getMovieList().map { it.toMovie() }
                movieDao.insertMovies(remoteMovies.map { it.toMovieEntity() })
                remoteMovies
            } catch (e: Exception) {
                val moviesList = movieDao.getAllMovies().first()
                if (moviesList.isEmpty())
                    emit(Result.Error(message = "Error loading Movies"))
                else
                    emit(Result.Success(moviesList.map { moviesEntity -> moviesEntity.toMovie() }))

                //emit(Result.Success(moviesList.toMovie()))
                return@flow
            }
            emit(Result.Success(moviesFromApi))
        }
    }
}
