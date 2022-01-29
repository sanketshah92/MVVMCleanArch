package com.sanket.domain.usecase

import com.sanket.data.models.artist.Artist
import com.sanket.domain.repository.ArtistsRepository

class GetArtistsUsecase(private val artistsRepository: ArtistsRepository) {
    suspend fun execute():List<Artist>?=artistsRepository.getArtists()
}