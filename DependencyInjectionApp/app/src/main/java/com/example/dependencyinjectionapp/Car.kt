package com.example.dependencyinjectionapp

import javax.inject.Inject

class Car @Inject constructor (private val engine: Engine) {
//    private val engine = Engine()

    fun start() {
        engine.startEngine()
    }


}