package com.sanket.data.repository.tvshow

import com.sanket.data.models.tvshow.TVShow
import com.sanket.domain.repository.TVShowsRepository

class TVShowRepositoryImpl:TVShowsRepository {
    override suspend fun getTvShows(): List<TVShow>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateTvShows(): List<TVShow>? {
        TODO("Not yet implemented")
    }
}