package com.sanket.domain.repository

import com.sanket.data.models.artist.Artist

interface ArtistsRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtist():List<Artist>?
}