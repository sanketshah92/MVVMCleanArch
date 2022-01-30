package com.sanket.data.repository.artist.dataSourceImpl

import com.sanket.data.db.ArtistDao
import com.sanket.data.models.artist.Artist
import com.sanket.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {
    override suspend fun getArtists(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtist(artist: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(artist)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteArtist()
        }
    }
}