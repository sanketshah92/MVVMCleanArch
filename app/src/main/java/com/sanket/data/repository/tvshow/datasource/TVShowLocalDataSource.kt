package com.sanket.data.repository.tvshow.datasource

import com.sanket.data.models.tvshow.TVShow

interface TVShowLocalDataSource {
    suspend fun saveTVShowToDB(tvShows:List<TVShow>)
    suspend fun clearAll()
    suspend fun getTVShowFromDB():List<TVShow>
}