package com.example.trackmyhabbit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.trackmyhabbit.data.HabitDao

// ViewModel Factory to provide HabitDao to the ViewModel
class HabitViewModelFactory(private val habitDao: HabitDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HabbitViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HabbitViewModel(habitDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}