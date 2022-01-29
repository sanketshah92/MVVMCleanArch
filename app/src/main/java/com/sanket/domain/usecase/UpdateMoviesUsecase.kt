package com.sanket.domain.usecase

import com.sanket.domain.repository.MoviewRepository

class UpdateMoviesUsecase(private val movieRepository: MoviewRepository) {
    suspend fun execute()=movieRepository.updateMovie()
}