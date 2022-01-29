package com.sanket.domain.repository

import com.sanket.data.models.movie.Movie

interface MoviewRepository {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovie():List<Movie>?
}