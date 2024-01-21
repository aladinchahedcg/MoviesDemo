package com.example.moviedummyapi.data.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.concurrent.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovies(myDataItemRoom: LiveData<List<MyDataItemRoom>>)

    @Query("SELECT * FROM my_data_items")
        fun getAllMovies(): kotlinx.coroutines.flow.Flow<List<MyDataItemRoom>>
}
