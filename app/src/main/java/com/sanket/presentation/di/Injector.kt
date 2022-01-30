package com.sanket.presentation.di

import com.sanket.presentation.di.artist.ArtistSubComponent
import com.sanket.presentation.di.movie.MovieSubComponent
import com.sanket.presentation.di.tvshow.TVShowSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createTVShowSubComponent():TVShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}