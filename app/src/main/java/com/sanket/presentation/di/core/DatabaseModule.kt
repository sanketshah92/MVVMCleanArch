package com.sanket.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.sanket.data.db.ArtistDao
import com.sanket.data.db.MovieDao
import com.sanket.data.db.TMDBDatabase
import com.sanket.data.db.TVShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDb(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient").build()
    }

    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }

    @Provides
    fun provideTVShowDao(tmdbDatabase: TMDBDatabase): TVShowDao {
        return tmdbDatabase.tvShowDao()
    }
}