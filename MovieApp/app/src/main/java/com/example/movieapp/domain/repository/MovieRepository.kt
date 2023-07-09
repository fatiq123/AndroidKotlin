package com.example.movieapp.domain.repository

import com.example.movieapp.data.model.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?

    //by adding ? at end of list wont allow any null value in the list while add ? like List<Movie?> allows null-able values
}