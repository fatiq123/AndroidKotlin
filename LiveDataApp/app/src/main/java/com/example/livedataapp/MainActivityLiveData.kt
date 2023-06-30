package com.example.livedataapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityLiveData(startingNumber: Int) : ViewModel() {

    var total =
        MutableLiveData<Int>()  // mutable can be changed i mean MutableLiveData can be changed
    val totalSum: LiveData<Int> //remember i do not add get by myself it automatically add getter to LiveData<T>  because we cannot change the LiveData<T>
        get() {
            return total
        }

    init {
        total.value = startingNumber
    }


    fun sumUp(input: Int) {
        total.value = (total.value)?.plus(input)
    }

}