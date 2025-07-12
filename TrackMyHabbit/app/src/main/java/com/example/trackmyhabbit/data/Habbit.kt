package com.example.trackmyhabbit.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habits")
data class Habbit(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name : String,
    val imageURL : String?,
    val currentCount: Int = 0,
    val targetCount: Int = 1
)
