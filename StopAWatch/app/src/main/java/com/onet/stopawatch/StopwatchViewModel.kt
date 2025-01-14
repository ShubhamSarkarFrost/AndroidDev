package com.onet.stopawatch

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class StopwatchViewModel : ViewModel() {
    private var _time = mutableStateOf(0L)
    val time: State<Long> get() = _time

    private var isRunning = false

    fun start() {
        if (isRunning) return
        isRunning = true
        viewModelScope.launch {
            while (isRunning) {
                delay(500L)
                _time.value++
            }
        }
    }

    fun stop() {
        isRunning = false
    }

    fun reset() {
        isRunning = false
        _time.value = 0L
    }

    fun formatTime(seconds: Long): String {
        val hours = TimeUnit.SECONDS.toHours(seconds)
        val minutes = TimeUnit.SECONDS.toMinutes(seconds) % 60
        val secs = seconds % 60
        return String.format("%02d:%02d:%02d", hours, minutes, secs)
    }
}
