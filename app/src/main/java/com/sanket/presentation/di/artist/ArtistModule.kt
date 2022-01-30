package com.sanket.presentation.di.artist

import com.sanket.domain.usecase.GetArtistsUsecase
import com.sanket.domain.usecase.UpdateArtistsUsecase
import com.sanket.presentation.artist.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUsecase: GetArtistsUsecase,
        updateArtistsUsecase: UpdateArtistsUsecase
    ):ArtistsViewModelFactory {
            return ArtistsViewModelFactory(getArtistsUsecase,updateArtistsUsecase)
    }
}