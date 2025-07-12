package com.example.trackmyhabbit.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Query("SELECT * from habits ORDER BY id DESC")
    fun getAllHabbits(): Flow<List<Habbit>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHabit(habbit: Habbit)

    @Update
    suspend fun updateHabit(habit: Habbit)

    @Query("DELETE FROM habits WHERE id = :habitId")
    suspend fun deleteHabit(habitId: Int)

    @Query("SELECT * FROM habits WHERE id = :habitId")
    fun getHabitById(habitId: Int): Flow<Habbit?>

}