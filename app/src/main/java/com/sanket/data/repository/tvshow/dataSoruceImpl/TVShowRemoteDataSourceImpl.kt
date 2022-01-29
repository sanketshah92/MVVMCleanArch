package com.sanket.data.repository.tvshow.dataSoruceImpl

import com.sanket.data.api.TMDBServices
import com.sanket.data.models.tvshow.TVShowList
import com.sanket.data.repository.tvshow.datasource.TVShowRemoteDataSource
import retrofit2.Response

class TVShowRemoteDataSourceImpl(
    private val tmdbServices: TMDBServices,
    private val apiKey: String
) : TVShowRemoteDataSource {
    override suspend fun getTVShows(): Response<TVShowList> {
        return tmdbServices.getPopularTVShows(apiKey)
    }
}