package com.sanket.data.repository.tvshow.datasource

import com.sanket.data.models.tvshow.TVShowList
import retrofit2.Response

interface TVShowRemoteDataSource {
    suspend fun getTVShows(): Response<TVShowList>
}