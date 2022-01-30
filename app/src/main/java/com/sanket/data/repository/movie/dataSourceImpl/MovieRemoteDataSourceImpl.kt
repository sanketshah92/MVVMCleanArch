package com.sanket.data.repository.movie.dataSourceImpl

import com.sanket.data.api.TMDBServices
import com.sanket.data.models.movie.MovieList
import com.sanket.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbServices: TMDBServices,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> =
        tmdbServices.getPopularMovies(apiKey)

}