package com.sanket.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sanket.domain.usecase.GetMoviesUsecase
import com.sanket.domain.usecase.UpdateMoviesUsecase

class MovieViewModel(
    private val getMoviesUsecase: GetMoviesUsecase,
    private val updateMoviesUsecase: UpdateMoviesUsecase
) : ViewModel() {

    fun getMovies() = liveData {
        val movies = getMoviesUsecase.execute()
        emit(movies)
    }

    fun updateMovie() = liveData {
        val movies = updateMoviesUsecase.execute()
        emit(movies)
    }
}