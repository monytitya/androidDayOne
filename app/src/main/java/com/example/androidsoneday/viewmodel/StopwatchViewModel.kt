package com.example.androidsoneday.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StopwatchViewModel: ViewModel()
{
    var seconds: Int = 0
        private set

    var isRunning: Boolean = false
        private set

    private var timerJob: Job? = null

    //call back
    var onTick: ((Int) -> Unit)? = null

    fun start()
    {
        if (isRunning) return
        isRunning = true
        timerJob = viewModelScope.launch {
            while (isRunning) {
                delay(1000L)
                seconds++
                onTick?.invoke(seconds)
            }
        }
    }

    fun pause ()
    {
        isRunning  = false
        timerJob?.cancel()
    }
    fun reset() {
        pause()
        seconds = 0
        onTick?.invoke(seconds)
    }
}