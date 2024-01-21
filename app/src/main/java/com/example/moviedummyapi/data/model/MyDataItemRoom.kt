package com.example.moviedummyapi.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey



fun MyDataItem.toEntity(): MyDataItemRoom {
    return MyDataItemRoom(id, Poster, Runtime, Title, Year)

}

@Entity(tableName = "my_data_items")
data class MyDataItemRoom(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val Poster: String,
    val Runtime: String,
    val Title: String,
    val Year: String
)

