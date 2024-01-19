package com.example.moviedummyapi.di

import com.example.moviedummyapi.data.MovieRepository
import com.example.moviedummyapi.data.MovieRepositoryImpl
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
}