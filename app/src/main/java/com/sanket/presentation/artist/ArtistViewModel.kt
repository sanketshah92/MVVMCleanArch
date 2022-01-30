package com.sanket.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sanket.domain.usecase.GetArtistsUsecase
import com.sanket.domain.usecase.UpdateArtistsUsecase

class ArtistViewModel(
    private val getArtistsUsecase: GetArtistsUsecase,
    private val updateArtistsUsecase: UpdateArtistsUsecase
) : ViewModel() {

    fun getArtists() = liveData {
        val artists = getArtistsUsecase.execute()
        emit(artists)
    }

    fun updateArtists() = liveData {
        val artists = updateArtistsUsecase.execute()
        emit(artists)
    }
}