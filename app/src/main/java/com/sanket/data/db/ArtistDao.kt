package com.sanket.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sanket.data.models.artist.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artist:List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteArtist()

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtists():List<Artist>
}