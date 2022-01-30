package com.sanket.presentation.di.core

import android.content.Context
import com.sanket.presentation.di.artist.ArtistSubComponent
import com.sanket.presentation.di.movie.MovieSubComponent
import com.sanket.presentation.di.tvshow.TVShowSubComponent
import dagger.Module
import dagger.Provides

@Module(subcomponents = [MovieSubComponent::class, TVShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}