package com.example.movieapp.presentation.di

import androidx.core.view.ViewCompat.ScrollIndicators
import com.example.movieapp.data.datasource.MovieLocalDataSource
import com.example.movieapp.data.datasourceimplementation.MovieLocalDataSourceImplementation
import com.example.movieapp.data.db.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton
@InstallIn(Singleton::class)
@Module
class LocalDataModule {


    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImplementation(movieDao = movieDao)
    }

}