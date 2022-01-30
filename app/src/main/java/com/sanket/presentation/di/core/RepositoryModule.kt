package com.sanket.presentation.di.core

import com.sanket.data.repository.artist.ArtistsRepositoryImpl
import com.sanket.data.repository.artist.dataSourceImpl.ArtistRemoteDataSourceImpl
import com.sanket.data.repository.artist.datasource.ArtistCacheDataSource
import com.sanket.data.repository.artist.datasource.ArtistLocalDataSource
import com.sanket.data.repository.artist.datasource.ArtistRemoteDataSource
import com.sanket.data.repository.movie.MovieRepositoryImpl
import com.sanket.data.repository.movie.datasource.MovieCacheDataSource
import com.sanket.data.repository.movie.datasource.MovieLocalDataSource
import com.sanket.data.repository.movie.datasource.MovieRemoteDataSource
import com.sanket.data.repository.tvshow.TVShowRepositoryImpl
import com.sanket.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.sanket.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.sanket.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.sanket.domain.repository.ArtistsRepository
import com.sanket.domain.repository.MoviewRepository
import com.sanket.domain.repository.TVShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource,
        movieRemoteDataSource: MovieRemoteDataSource
    ): MoviewRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        tvShowLocalDataSource: TVShowLocalDataSource,
        tvShowCacheDataSource: TVShowCacheDataSource,
        tvShowRemoteDataSource: TVShowRemoteDataSource
    ): TVShowsRepository {
        return TVShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTVShowRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistsRepository {
        return ArtistsRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}