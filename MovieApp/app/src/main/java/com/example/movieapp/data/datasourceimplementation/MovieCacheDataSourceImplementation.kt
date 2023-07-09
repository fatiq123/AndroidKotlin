package com.example.movieapp.data.datasourceimplementation

import com.example.movieapp.data.datasource.MovieCacheDataSource
import com.example.movieapp.data.model.Movie

class MovieCacheDataSourceImplementation : MovieCacheDataSource{

    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}