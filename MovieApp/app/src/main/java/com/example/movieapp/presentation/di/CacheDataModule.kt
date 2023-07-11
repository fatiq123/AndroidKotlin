package com.example.movieapp.presentation.di

import com.example.movieapp.data.datasource.MovieCacheDataSource
import com.example.movieapp.data.datasourceimplementation.MovieCacheDataSourceImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton
@InstallIn(Singleton::class)
@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImplementation()
    }

}