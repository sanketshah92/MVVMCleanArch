package com.sanket.data.repository.artist.datasource

import com.sanket.data.models.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtists():List<Artist>
    suspend fun saveArtist(artist: List<Artist>)
    suspend fun clearAll()
}