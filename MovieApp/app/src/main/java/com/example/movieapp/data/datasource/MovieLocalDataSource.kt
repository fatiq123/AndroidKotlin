package com.example.movieapp.data.datasource

import com.example.movieapp.data.model.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>

    suspend fun saveMoviesToDB(movie: List<Movie>)

    suspend fun clearAll()

}