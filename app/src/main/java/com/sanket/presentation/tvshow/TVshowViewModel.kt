package com.sanket.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sanket.domain.usecase.GetTVShowUsecase
import com.sanket.domain.usecase.UpdateTVShowUsecase

class TVshowViewModel(
    private val getTVShowUsecase: GetTVShowUsecase,
    private val updateTVShowUsecase: UpdateTVShowUsecase
) : ViewModel() {
    fun getTVShows() = liveData {
        val tvShows = getTVShowUsecase.execute()
        emit(tvShows)
    }

    fun updateTVShows() = liveData {
        val tvShows = updateTVShowUsecase.execute()
        emit(tvShows)
    }
}