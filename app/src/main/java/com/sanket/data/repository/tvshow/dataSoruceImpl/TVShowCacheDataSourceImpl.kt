package com.sanket.data.repository.tvshow.dataSoruceImpl

import com.sanket.data.models.tvshow.TVShow
import com.sanket.data.repository.tvshow.datasource.TVShowCacheDataSource

class TVShowCacheDataSourceImpl : TVShowCacheDataSource {
    private var cacheTVShows = ArrayList<TVShow>()
    override suspend fun getTVShowsFromCache(): List<TVShow> {
        return cacheTVShows
    }

    override suspend fun saveTVShowToCache(tvShows: List<TVShow>) {
        cacheTVShows.clear()
        cacheTVShows = ArrayList(tvShows)
    }
}