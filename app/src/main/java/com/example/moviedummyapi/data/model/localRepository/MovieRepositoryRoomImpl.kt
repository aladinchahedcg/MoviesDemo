package com.example.moviedummyapi.data.model.localRepository

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.moviedummyapi.data.API
import com.example.moviedummyapi.data.model.MovieDao
import com.example.moviedummyapi.data.model.MovieEntity
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject


@ViewModelScoped
class MovieRepositoryRoomImpl @Inject constructor(
    private val api: API,
    private val movieDao: MovieDao
): MovieRepositoryRoom {


val getALLmovies : Flow<List<MovieEntity>> = movieDao.getAllMovies()
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getMoviesListRoom(): Flow<List<MovieEntity>> {
        return flow {
            val moviesFromRepo = try {
                api.getMovieListRoom()
            } catch (e: IOException) {
                emit(emptyList())
                return@flow
            } catch (e: HttpException) {
                emit(emptyList())
                return@flow
            } catch (e: Exception) {
                emit(emptyList())
                return@flow
            }
            emit(moviesFromRepo)
        }
    }
}
