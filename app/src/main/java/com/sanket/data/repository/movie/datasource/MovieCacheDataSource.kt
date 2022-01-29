package com.sanket.data.repository.movie.datasource

import com.sanket.data.models.movie.Movie

interface MovieCacheDataSource {
    suspend fun saveMoviesToCache(movies: List<Movie>)
    suspend fun getMoviesFromCache(): List<Movie>
}