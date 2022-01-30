package com.sanket.data.repository.movie.datasource

import com.sanket.data.models.movie.Movie
import com.sanket.data.models.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MovieList>
}