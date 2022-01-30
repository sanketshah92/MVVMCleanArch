package com.sanket.domain.usecase

import com.sanket.data.models.tvshow.TVShow
import com.sanket.domain.repository.TVShowsRepository

class GetTVShowUsecase(private val tvShowsRepository: TVShowsRepository) {
    suspend fun execute():List<TVShow>? = tvShowsRepository.getTvShows()
}