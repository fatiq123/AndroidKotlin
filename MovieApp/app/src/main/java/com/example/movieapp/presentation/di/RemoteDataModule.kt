package com.example.movieapp.presentation.di

import com.example.movieapp.BuildConfig
import com.example.movieapp.data.api.TMDBService
import com.example.movieapp.data.datasource.MovieRemoteDataSource
import com.example.movieapp.data.datasourceimplementation.MovieRemoteDataSourceImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Named
import javax.inject.Singleton
@InstallIn(Singleton::class)
@Module
//class RemoteDataModule(private val apiKey: String) {
//
//
//    @Singleton
//    @Provides
//    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
//        return MovieRemoteDataSourceImplementation(tmdbService = tmdbService, apiKey = apiKey)
//    }
//
//}
class RemoteDataModule {

    @Provides
    @Singleton
    @Named(BuildConfig.API_KEY)
    fun provideApiKey(): String {
        return BuildConfig.API_KEY
    }

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService, apiKey: String): MovieRemoteDataSource {
        return MovieRemoteDataSourceImplementation(tmdbService = tmdbService, apiKey = apiKey)
    }
}