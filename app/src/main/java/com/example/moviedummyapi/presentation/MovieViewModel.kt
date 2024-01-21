package com.example.moviedummyapi.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedummyapi.data.Result
import com.example.moviedummyapi.data.model.Movie
import com.example.moviedummyapi.data.model.MovieEntity
import com.example.moviedummyapi.data.model.localRepository.MovieRepositoryRoomImpl
import com.example.moviedummyapi.data.model.remoteRepository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieRepositoryRoomImpl: MovieRepositoryRoomImpl

) : ViewModel() {
    private val _moviesLocal = MutableStateFlow<List<MovieEntity>>(emptyList())
    val moviesLocal = _moviesLocal.asStateFlow()

    fun getALlmovies() {
        viewModelScope.launch {
            movieRepositoryRoomImpl.getALLmovies.collect() {
                _moviesLocal.value = it
            }
        }
    }

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies = _movies.asStateFlow()


    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()


    init {
        viewModelScope.launch {
            movieRepository.getMovieList().collectLatest { result ->
                when (result) {
                    is Result.Error -> {
                        _showErrorToastChannel.send(true)
                        //getALlmovies()
                    }

                    is Result.Success -> {
                        result.data?.let { movies ->
                            _movies.update { movies }
                        }
                    }
                }
            }
        }
    }
}