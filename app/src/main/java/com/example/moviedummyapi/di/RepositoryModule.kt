package com.example.moviedummyapi.di

import android.content.Context
import androidx.room.Room
import com.example.moviedummyapi.data.model.MovieDataBase
import com.example.moviedummyapi.data.model.localRepository.MovieRepositoryRoom
import com.example.moviedummyapi.data.model.localRepository.MovieRepositoryRoomImpl
import com.example.moviedummyapi.data.model.remoteRepository.MovieRepository
import com.example.moviedummyapi.data.model.remoteRepository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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


    //Local Room Database
    @Singleton
    @Provides
    fun getDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        MovieDataBase::class.java,
        "movieDB"
    ).build()


    @Singleton
    @Provides
    fun provideDao(movieDataBase: MovieDataBase) = movieDataBase.movieDao

}
