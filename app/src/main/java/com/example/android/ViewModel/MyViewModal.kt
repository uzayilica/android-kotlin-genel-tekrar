package com.example.android.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    // MutableLiveData, veri güncellemelerine izin verir
    private val _counter: MutableLiveData<Int> = MutableLiveData(0)

    // LiveData, dışarıdan sadece okunabilir
    val counter: LiveData<Int> = _counter

    // Sayacı sıfırlayan fonksiyon
    fun resetCounter() {
        _counter.value = 0
    }

    // Sayacı artırma işlemi
    fun incrementCounter() {
        _counter.value = (_counter.value ?: 0) + 1
    }
    fun decrementCounter() {
        _counter.value = (_counter.value ?: 0) + -1
    }
}
