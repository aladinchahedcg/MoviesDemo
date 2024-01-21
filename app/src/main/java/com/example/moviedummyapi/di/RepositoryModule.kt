package com.example.moviedummyapi.di

import com.example.moviedummyapi.data.model.localRepository.MovieRepositoryRoom
import com.example.moviedummyapi.data.model.localRepository.MovieRepositoryRoomImpl
import com.example.moviedummyapi.data.model.remoteRepository.MovieRepository
import com.example.moviedummyapi.data.model.remoteRepository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsRepository(
        repositoryImpl: MovieRepositoryImpl
    ): MovieRepository

    @Binds
    @Singleton
    abstract fun bindsRepositoryRoom(
        repositoryImplRoom: MovieRepositoryRoomImpl
    ): MovieRepositoryRoom


}
