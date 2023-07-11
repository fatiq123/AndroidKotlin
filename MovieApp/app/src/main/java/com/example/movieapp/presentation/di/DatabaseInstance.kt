package com.example.movieapp.presentation.di

import android.content.Context
import androidx.room.Insert
import androidx.room.Room
import com.example.movieapp.data.api.TMDBService
import com.example.movieapp.data.db.MovieDao
import com.example.movieapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton
@InstallIn(ActivityComponent::class)
@Module
class DatabaseInstance {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(
            context = context,
            TMDBDatabase::class.java,
            "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }
}