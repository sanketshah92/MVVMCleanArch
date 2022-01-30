package com.sanket.presentation

import android.app.Application
import com.sanket.BuildConfig
import com.sanket.presentation.di.Injector
import com.sanket.presentation.di.artist.ArtistSubComponent
import com.sanket.presentation.di.core.*
import com.sanket.presentation.di.movie.MovieSubComponent
import com.sanket.presentation.di.tvshow.TVShowSubComponent

class App:Application(),Injector {

    private lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }
    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponet().create()
    }

    override fun createTVShowSubComponent(): TVShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}