package com.sanket.data.repository.artist.dataSourceImpl

import com.sanket.data.models.artist.Artist
import com.sanket.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl:ArtistCacheDataSource {
    private var cacheArtists = ArrayList<Artist>()
    override suspend fun saveArtistToCache(artist: List<Artist>) {
        cacheArtists.clear()
        cacheArtists = ArrayList(artist)
    }

    override suspend fun getArtistFromCache(): List<Artist> {
        return cacheArtists
    }
}