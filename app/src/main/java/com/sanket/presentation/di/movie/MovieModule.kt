package com.sanket.presentation.di.movie

import com.sanket.data.models.movie.Movie
import com.sanket.domain.usecase.GetMoviesUsecase
import com.sanket.domain.usecase.UpdateMoviesUsecase
import com.sanket.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUsecase: GetMoviesUsecase,
        updateMoviesUsecase: UpdateMoviesUsecase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUsecase, updateMoviesUsecase)
    }
}