package com.example.movieapp.presentation.di

import com.example.movieapp.presentation.di.MovieSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
}