package com.example.moviedummyapi.data.model.remoteRepository

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.moviedummyapi.data.API
import com.example.moviedummyapi.data.Result
import com.example.moviedummyapi.data.model.MyDataItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: API

) : MovieRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getMovieList(): Flow<Result<List<MyDataItem>>> {
        return flow {
            val moviesFromApi = try {
                api.getMovieList()
            } catch (e: IOException) {
                emit(Result.Error(message = "Error loading Movies"))
                return@flow
            } catch (e: HttpException) {
                emit(Result.Error(message = "Error loading Movies"))
                return@flow
            } catch (e: Exception) {
                emit(Result.Error(message = "Error loading Movies"))
                return@flow
            }
            emit(Result.Success(moviesFromApi))
        }
    }
}
