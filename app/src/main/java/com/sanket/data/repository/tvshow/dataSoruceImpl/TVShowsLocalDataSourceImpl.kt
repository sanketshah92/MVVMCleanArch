package com.sanket.data.repository.tvshow.dataSoruceImpl

import com.sanket.data.db.TVShowDao
import com.sanket.data.models.tvshow.TVShow
import com.sanket.data.repository.tvshow.datasource.TVShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowsLocalDataSourceImpl(private val tvShowDao: TVShowDao) : TVShowLocalDataSource {
    override suspend fun saveTVShowToDB(tvShows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.insertTvShow(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteTvShow()
        }
    }

    override suspend fun getTVShowFromDB(): List<TVShow> {
        return tvShowDao.getTVShows()
    }
}