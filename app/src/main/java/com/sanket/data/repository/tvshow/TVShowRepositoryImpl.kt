package com.sanket.data.repository.tvshow

import com.sanket.data.models.tvshow.TVShow
import com.sanket.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.sanket.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.sanket.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.sanket.domain.repository.TVShowsRepository
import java.lang.Exception

class TVShowRepositoryImpl(
    private val tvShowRemoteDataSource: TVShowRemoteDataSource,
    private val tvShowLocalDataSource: TVShowLocalDataSource,
    private val tvShowCacheDataSource: TVShowCacheDataSource
) : TVShowsRepository {
    override suspend fun getTvShows(): List<TVShow>? {
        return getTVShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TVShow>? {
        val newTVShows = getTVShowFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTVShowToDB(newTVShows)
        tvShowCacheDataSource.saveTVShowToCache(newTVShows)
        return newTVShows
    }

    suspend fun getTVShowFromAPI(): List<TVShow> {
        lateinit var tvShows: List<TVShow>
        try {
            val response = tvShowRemoteDataSource.getTVShows()
            val body = response.body()
            if (body != null) {
                body.TVShows?.let {
                    tvShows = body.TVShows
                }
            }
        } catch (e: Exception) {
            tvShows = emptyList()
        }
        return tvShows
    }

    suspend fun getTVShowsFromDB(): List<TVShow> {
        lateinit var tvShows: List<TVShow>
        try {
            tvShows = tvShowLocalDataSource.getTVShowFromDB()
        } catch (e: Exception) {
            tvShows = emptyList()
        }
        if (tvShows.isEmpty()) {
            tvShows = getTVShowFromAPI()
            tvShowLocalDataSource.saveTVShowToDB(tvShows)
        }
        return tvShows
    }

    suspend fun getTVShowsFromCache(): List<TVShow> {
        lateinit var tvShows: List<TVShow>
        try {
            tvShows = tvShowCacheDataSource.getTVShowsFromCache()
        } catch (e: Exception) {
            tvShows = emptyList()
        }
        if (tvShows.isEmpty()) {
            tvShows = getTVShowsFromDB()
            tvShowCacheDataSource.saveTVShowToCache(tvShows)
        }
        return tvShows
    }
}