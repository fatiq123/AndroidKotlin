package com.example.movieapp.presentation.di

import com.example.movieapp.domain.usecases.GetMoviesUseCase
import com.example.movieapp.domain.usecases.UpdateMoviesUseCase
import com.example.movieapp.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase,
    ): ViewModelFactory {
        return ViewModelFactory(
            getMoviesUseCase = getMoviesUseCase,
            updateMoviesUseCase = updateMoviesUseCase
        )
    }
}
