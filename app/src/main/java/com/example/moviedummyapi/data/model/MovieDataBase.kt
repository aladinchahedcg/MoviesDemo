package com.example.moviedummyapi.data.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [MyDataItemRoom::class], version =1, exportSchema = false)
abstract class MovieDataBase: RoomDatabase (){

    abstract val movieDao: MovieDao
}

