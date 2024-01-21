package com.example.moviedummyapi.di

import android.content.Context
import androidx.room.Room
import com.example.moviedummyapi.RetrofitInstance
import com.example.moviedummyapi.data.API
import com.example.moviedummyapi.data.model.MovieDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): API {
        return RetrofitInstance.api
    }

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