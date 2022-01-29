package com.sanket.data.repository.artist.datasource

import com.sanket.data.models.artist.Artist

interface ArtistCacheDataSource {
    suspend fun saveArtistToCache(artist:List<Artist>)
    suspend fun getArtistFromCache():List<Artist>
}