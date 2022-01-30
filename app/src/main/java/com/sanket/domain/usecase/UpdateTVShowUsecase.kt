package com.sanket.domain.usecase

import com.sanket.data.models.tvshow.TVShow
import com.sanket.domain.repository.TVShowsRepository

class UpdateTVShowUsecase(private val tvShowsRepository: TVShowsRepository) {
    suspend fun execute():List<TVShow>? = tvShowsRepository.updateTvShows()
}