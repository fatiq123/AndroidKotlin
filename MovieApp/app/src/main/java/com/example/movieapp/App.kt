package com.example.movieapp

import android.app.Application
import com.example.movieapp.presentation.di.AppComponent
import com.example.movieapp.presentation.di.Injector
import com.example.movieapp.presentation.di.MovieSubComponent
import dagger.Module
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application(){

//    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

    }

//    override fun createMovieSubComponent(): MovieSubComponent {
//        TODO("Not yet implemented")
//    }
}