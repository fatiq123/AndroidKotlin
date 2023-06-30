package com.example.viewmodelapp

import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingNumber: Int) : ViewModel() {

    private var counter = 0

    fun getCurrentCount(): Int {
        return counter
    }

    fun getUpdatedCount(): Int {
        return ++counter
    }
}