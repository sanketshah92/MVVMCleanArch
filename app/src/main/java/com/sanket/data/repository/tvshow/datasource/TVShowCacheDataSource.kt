package com.sanket.data.repository.tvshow.datasource

import com.sanket.data.models.tvshow.TVShow

interface TVShowCacheDataSource {
    suspend fun getTVShowsFromCache():List<TVShow>
    suspend fun saveTVShowToCache(tvShows: List<TVShow>)
}