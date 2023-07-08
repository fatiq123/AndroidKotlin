package com.example.dependencyinjectionapp

import javax.inject.Inject

class Engine @Inject constructor() {

    fun startEngine() {
        print("Engine is start")
    }
}