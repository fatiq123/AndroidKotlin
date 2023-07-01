package com.example.viewmodellivedatadatabindingapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    // read only property
    private var counter = MutableLiveData<Int>()
    val countData: LiveData<Int>
        get() {
            return counter
        }

    init {
        counter.value = 0
    }

    fun updateCounter() {
        counter.value = (counter.value)?.plus(1)
    }
}