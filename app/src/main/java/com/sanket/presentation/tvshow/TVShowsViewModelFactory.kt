package com.sanket.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sanket.domain.usecase.GetTVShowUsecase
import com.sanket.domain.usecase.UpdateTVShowUsecase

class TVShowsViewModelFactory(
    private val getTVShowUsecase: GetTVShowUsecase,
    private val updateTVShowUsecase: UpdateTVShowUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TVshowViewModel(getTVShowUsecase, updateTVShowUsecase) as T
    }
}