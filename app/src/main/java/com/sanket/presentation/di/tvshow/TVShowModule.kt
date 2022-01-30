package com.sanket.presentation.di.tvshow

import com.sanket.domain.usecase.GetTVShowUsecase
import com.sanket.domain.usecase.UpdateTVShowUsecase
import com.sanket.presentation.tvshow.TVShowsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TVShowModule {

    @TVShowScope
    @Provides
    fun provideTVShowFactory(
        getTVShowUsecase: GetTVShowUsecase,
        updateTVShowUsecase: UpdateTVShowUsecase
    ): TVShowsViewModelFactory {
        return TVShowsViewModelFactory(getTVShowUsecase, updateTVShowUsecase)
    }
}