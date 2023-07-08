package com.example.dependencyinjectionapp

import dagger.Component

@Component
interface CarComponent {
    fun getCarInstance(): Car
}