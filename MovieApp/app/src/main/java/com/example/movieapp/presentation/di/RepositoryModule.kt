package com.example.movieapp.presentation.di

import com.example.movieapp.data.MovieRepositoryImplementation
import com.example.movieapp.data.datasource.MovieCacheDataSource
import com.example.movieapp.data.datasource.MovieLocalDataSource
import com.example.movieapp.data.datasource.MovieRemoteDataSource
import com.example.movieapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource

    ): MovieRepository {

        return MovieRepositoryImplementation(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )

    }

}