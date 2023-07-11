package com.example.movieapp.presentation.di

import com.example.movieapp.App
import com.example.movieapp.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

//@MovieScope
//@Subcomponent(modules = [MovieModule::class])
@Singleton
@Component
interface MovieSubComponent {

    fun inject(movieActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance app: App): MovieSubComponent
    }
}