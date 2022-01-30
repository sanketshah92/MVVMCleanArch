package com.sanket.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sanket.domain.usecase.GetArtistsUsecase
import com.sanket.domain.usecase.UpdateArtistsUsecase

class ArtistsViewModelFactory(
    private val getArtistsUsecase: GetArtistsUsecase,
    private val updateArtistsUsecase: UpdateArtistsUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUsecase, updateArtistsUsecase) as T
    }
}