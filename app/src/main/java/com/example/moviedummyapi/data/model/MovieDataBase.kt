package com.example.moviedummyapi.data.model

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [MovieEntity::class], version =1, exportSchema = false)
abstract class MovieDataBase: RoomDatabase (){

    abstract val movieDao: MovieDao
}

