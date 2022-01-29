package com.sanket.domain.repository

import com.sanket.data.models.tvshow.TVShow

interface TVShowsRepository {
    suspend fun getTvShows():List<TVShow>?
    suspend fun updateTvShows():List<TVShow>?
}