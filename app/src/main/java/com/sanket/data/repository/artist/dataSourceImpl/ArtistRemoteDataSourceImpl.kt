package com.sanket.data.repository.artist.dataSourceImpl

import com.sanket.data.api.TMDBServices
import com.sanket.data.models.artist.ArtistList
import com.sanket.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbServices: TMDBServices,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> =
        tmdbServices.getPopularArtists(apiKey)

}