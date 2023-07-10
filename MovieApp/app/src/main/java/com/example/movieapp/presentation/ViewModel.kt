package com.example.movieapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapp.domain.usecases.GetMoviesUseCase
import com.example.movieapp.domain.usecases.UpdateMoviesUseCase

class ViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase,
) : ViewModel() {

    private fun getMovies(): LiveData<Any> = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList!!)
    }

    private fun updateMovies(): LiveData<Any> = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList!!)
    }
}