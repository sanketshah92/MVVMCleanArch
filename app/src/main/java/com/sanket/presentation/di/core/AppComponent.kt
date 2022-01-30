package com.sanket.presentation.di.core

import com.sanket.presentation.di.artist.ArtistSubComponent
import com.sanket.presentation.di.movie.MovieSubComponent
import com.sanket.presentation.di.tvshow.TVShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
    CacheDataModule::class,
    DatabaseModule::class,
    LocalDataModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class])
interface AppComponent {
    fun movieSubComponet():MovieSubComponent.Factory
    fun tvShowSubComponent():TVShowSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory
}