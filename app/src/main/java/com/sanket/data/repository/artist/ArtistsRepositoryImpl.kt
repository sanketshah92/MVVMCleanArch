package com.sanket.data.repository.artist

import com.sanket.data.models.artist.Artist
import com.sanket.data.repository.artist.datasource.ArtistCacheDataSource
import com.sanket.data.repository.artist.datasource.ArtistLocalDataSource
import com.sanket.data.repository.artist.datasource.ArtistRemoteDataSource
import com.sanket.domain.repository.ArtistsRepository
import java.lang.Exception

class ArtistsRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistsRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newArtists = getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtist(newArtists)
        artistCacheDataSource.saveArtistToCache(newArtists)
        return newArtists
    }

    suspend fun getArtistFromAPI(): List<Artist> {
        lateinit var artist: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                body.artists?.let {
                    artist = body.artists
                }
            }
        } catch (e: Exception) {
            artist = emptyList()
        }
        return artist
    }

    suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artist: List<Artist>
        try {
            artist = artistLocalDataSource.getArtists()
        } catch (e: Exception) {
            artist = emptyList()
        }
        if (artist.isEmpty()) {
            artist = getArtistFromAPI()
            artistLocalDataSource.saveArtist(artist)
        }
        return artist
    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artist: List<Artist>
        try {
            artist = artistCacheDataSource.getArtistFromCache()
        } catch (e: Exception) {
            artist = emptyList()
        }
        if (artist.isEmpty()) {
            artist = getArtistFromDB()
            artistCacheDataSource.saveArtistToCache(artist)
        }
        return artist
    }
}