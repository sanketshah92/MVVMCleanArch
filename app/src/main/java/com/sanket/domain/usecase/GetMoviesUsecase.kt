package com.sanket.domain.usecase

import com.sanket.data.models.movie.Movie
import com.sanket.domain.repository.MoviewRepository

class GetMoviesUsecase(private val moviewRepository: MoviewRepository) {
    suspend fun execute():List<Movie>? = moviewRepository.getMovies()
}