package com.sanket.presentation.di.core

import com.sanket.domain.repository.ArtistsRepository
import com.sanket.domain.repository.MoviewRepository
import com.sanket.domain.repository.TVShowsRepository
import com.sanket.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideMovieUseCases(moviewRepository: MoviewRepository): GetMoviesUsecase {
        return GetMoviesUsecase(moviewRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(moviewRepository: MoviewRepository): UpdateMoviesUsecase {
        return UpdateMoviesUsecase(moviewRepository)
    }


    @Provides
    fun provideArtistUseCases(artistsRepository: ArtistsRepository): GetArtistsUsecase {
        return GetArtistsUsecase(artistsRepository)
    }


    @Provides
    fun provideUpdateArtistUseCase(artistsRepository: ArtistsRepository): UpdateArtistsUsecase {
        return UpdateArtistsUsecase(artistsRepository)
    }

    @Provides
    fun provideTVShowUseCases(tvShowsRepository: TVShowsRepository): GetTVShowUsecase {
        return GetTVShowUsecase(tvShowsRepository)
    }


    @Provides
    fun provideUpdateTVShowUseCase(tvShowsRepository: TVShowsRepository): UpdateTVShowUsecase {
        return UpdateTVShowUsecase(tvShowsRepository)
    }

}