package com.example.dependencyinjectionapp

class Car(private val engine: Engine) {
//    private val engine = Engine()

    fun start() {
        engine.startEngine()
    }


}