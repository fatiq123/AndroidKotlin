package com.example.movieapp.presentation.di

import android.app.Application
import android.content.Context
import com.example.movieapp.App
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import javax.inject.Singleton
@Module
@InstallIn(ActivityComponent::class)
//@Module(subcomponents = [MovieSubComponent::class])
//class AppModule(private val context: Context) {
//
//    @Singleton
//    @Provides
//    fun provideApplicationContext(): Context {
//        return context.applicationContext
//    }
//}

object AppModule {

    @Singleton
    @Provides
    fun provideApplicationContext(application: Application): Context {
        return application.applicationContext
    }
}