package com.example.trackmyhabbit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.trackmyhabbit.data.Habbit
import com.example.trackmyhabbit.data.HabitDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HabbitViewModel (private val habitDao:HabitDao): ViewModel(){
    private val _habits = MutableStateFlow<List<Habbit>>(emptyList())
    val habits: StateFlow<List<Habbit>> = _habits.asStateFlow()


    init {
        viewModelScope.launch {
            habitDao.getAllHabbits().collectLatest { habitList -> _habits.value = habitList }
        }
    }


    fun addHabit(name:String, imageURL: String?){
        val newHabit = Habbit(name = name, imageURL = imageURL)
        viewModelScope.launch {
            habitDao.insertHabit(newHabit)
        }
    }

    fun incrementHabbitCounter(habbit: Habbit){
        val updatedHabbit = habbit.copy(currentCount = habbit.currentCount + 1)
        viewModelScope.launch {
            habitDao.updateHabit(updatedHabbit)
        }
    }

    fun resetHabitCounter(habit: Habbit) {
        val updatedHabit = habit.copy(currentCount = 0)
        viewModelScope.launch {
            habitDao.updateHabit(updatedHabit)
        }
    }

    fun deleteHabit(habitId: Int) {
        viewModelScope.launch {
            habitDao.deleteHabit(habitId)
        }
    }

}