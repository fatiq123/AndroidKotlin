package com.example.movieapp.data

import com.example.movieapp.data.datasource.MovieCacheDataSource
import com.example.movieapp.data.datasource.MovieLocalDataSource
import com.example.movieapp.data.datasource.MovieRemoteDataSource
import com.example.movieapp.data.model.Movie
import com.example.movieapp.domain.repository.MovieRepository


class MovieRepositoryImplementation(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource,
) : MovieRepository {


    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }


    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()

        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }


    private suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (exception: Exception) {

        }
        return movieList
    }


    private suspend fun getMoviesFromROOM(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception) {

        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movie = movieList)
        }
        return movieList

    }

    private suspend fun getMoviesFromCache(): List<Movie>? {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {

        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromROOM()
            movieCacheDataSource.saveMoviesToCache(movies = movieList)
        }
        return movieList
    }
}