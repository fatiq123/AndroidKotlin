package com.example.movieapp.presentation.di

import com.example.movieapp.data.MovieRepositoryImplementation
import com.example.movieapp.data.datasource.MovieCacheDataSource
import com.example.movieapp.data.datasource.MovieLocalDataSource
import com.example.movieapp.data.datasource.MovieRemoteDataSource
import com.example.movieapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton
@InstallIn(ActivityComponent::class)
@Module
class RepositoryModule() {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieCacheDataSource: MovieCacheDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieRemoteDataSource: MovieRemoteDataSource
    ): MovieRepository {

        return MovieRepositoryImplementation(
            movieCacheDataSource = movieCacheDataSource,
            movieLocalDataSource = movieLocalDataSource,
            movieRemoteDataSource = movieRemoteDataSource
        )
    }

}
