package com.sanket.presentation.di.core

import com.sanket.data.repository.artist.dataSourceImpl.ArtistCacheDataSourceImpl
import com.sanket.data.repository.artist.datasource.ArtistCacheDataSource
import com.sanket.data.repository.movie.dataSourceImpl.MovieCacheDataSourceImpl
import com.sanket.data.repository.movie.datasource.MovieCacheDataSource
import com.sanket.data.repository.tvshow.dataSoruceImpl.TVShowCacheDataSourceImpl
import com.sanket.data.repository.tvshow.datasource.TVShowCacheDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTVshowDataSource(): TVShowCacheDataSource {
        return TVShowCacheDataSourceImpl()
    }

}