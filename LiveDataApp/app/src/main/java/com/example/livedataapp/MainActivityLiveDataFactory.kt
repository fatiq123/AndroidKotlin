package com.example.livedataapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityLiveDataFactory(private val startingNum: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityLiveData::class.java)) {
            return MainActivityLiveData(startingNum) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}