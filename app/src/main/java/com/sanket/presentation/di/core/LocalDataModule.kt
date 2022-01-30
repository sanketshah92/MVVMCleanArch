package com.sanket.presentation.di.core

import com.sanket.data.api.TMDBServices
import com.sanket.data.db.ArtistDao
import com.sanket.data.db.MovieDao
import com.sanket.data.db.TVShowDao
import com.sanket.data.repository.artist.dataSourceImpl.ArtistLocalDataSourceImpl
import com.sanket.data.repository.artist.dataSourceImpl.ArtistRemoteDataSourceImpl
import com.sanket.data.repository.artist.datasource.ArtistLocalDataSource
import com.sanket.data.repository.artist.datasource.ArtistRemoteDataSource
import com.sanket.data.repository.movie.dataSourceImpl.MovieLocalDataSourceImpl
import com.sanket.data.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.sanket.data.repository.movie.datasource.MovieLocalDataSource
import com.sanket.data.repository.movie.datasource.MovieRemoteDataSource
import com.sanket.data.repository.tvshow.dataSoruceImpl.TVShowRemoteDataSourceImpl
import com.sanket.data.repository.tvshow.dataSoruceImpl.TVShowsLocalDataSourceImpl
import com.sanket.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.sanket.data.repository.tvshow.datasource.TVShowRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule() {

    @Singleton
    @Provides
    fun providesMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun providesArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun providesTVShowLocalDataSource(tvShowDao: TVShowDao): TVShowLocalDataSource {
        return TVShowsLocalDataSourceImpl(tvShowDao)
    }
}