package com.example.moviedummyapi.di

import com.example.moviedummyapi.RetrofitInstance
import com.example.moviedummyapi.data.API
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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

    /*
    @Provides
    @Singleton
    fun provideRepository(api : API): MovieRepository{
        return MovieRepositoryImpl(api)
    }

     */




}