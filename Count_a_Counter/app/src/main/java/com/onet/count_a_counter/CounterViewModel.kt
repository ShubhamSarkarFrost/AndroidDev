package com.onet.count_a_counter

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class CounterViewModel : ViewModel() {

    // Private mutable state for the counter value
    private val _count = mutableStateOf(0)

    // Public immutable state for external access
    val count: State<Int> get() = _count

    // Function to increment the counter
    fun increment() {
        _count.value++
    }

    // Function to decrement the counter
    fun decrement() {
        _count.value--
    }
}