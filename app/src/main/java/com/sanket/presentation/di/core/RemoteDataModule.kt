package com.sanket.presentation.di.core

import com.sanket.data.api.TMDBServices
import com.sanket.data.repository.artist.dataSourceImpl.ArtistRemoteDataSourceImpl
import com.sanket.data.repository.artist.datasource.ArtistRemoteDataSource
import com.sanket.data.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.sanket.data.repository.movie.datasource.MovieRemoteDataSource
import com.sanket.data.repository.tvshow.dataSoruceImpl.TVShowRemoteDataSourceImpl
import com.sanket.data.repository.tvshow.datasource.TVShowRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbServices: TMDBServices): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbServices, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbServices: TMDBServices): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbServices, apiKey)
    }

    @Singleton
    @Provides
    fun provideTVShowRemoteDataSource(tmdbServices: TMDBServices): TVShowRemoteDataSource {
        return TVShowRemoteDataSourceImpl(tmdbServices, apiKey)
    }
}