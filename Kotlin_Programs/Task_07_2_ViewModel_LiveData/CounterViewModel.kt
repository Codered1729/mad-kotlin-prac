package com.example.counter_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/*
INSTRUCTIONS:
ViewModel for Counter App. Match package name in line 1 to your project.
*/

class CounterViewModel : ViewModel() {
    private val _c = MutableLiveData(0)
    val c: LiveData<Int> = _c

    fun increment() {
        _c.value = (_c.value ?: 0) + 1
    }
}
