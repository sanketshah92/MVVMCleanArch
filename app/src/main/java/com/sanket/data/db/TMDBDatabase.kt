package com.sanket.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sanket.data.models.artist.Artist
import com.sanket.data.models.movie.Movie
import com.sanket.data.models.tvshow.TVShow

@Database(
    entities = [Movie::class, Artist::class, TVShow::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TVShowDao
    abstract fun artistDao(): ArtistDao
}