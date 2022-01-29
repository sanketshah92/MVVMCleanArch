package com.sanket.data.repository.artist.datasource

import com.sanket.data.models.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists():Response<ArtistList>
}