package com.sanket.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sanket.data.models.tvshow.TVShow

@Dao
interface TVShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShow(tvShow: List<TVShow>)

    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteTvShow()

    @Query("SELECT * FROM popular_tvShows")
    suspend fun getTVShows():List<TVShow>
}