package com.sanket.data.models.tvshow


import com.google.gson.annotations.SerializedName

data class TVShowList(

    @SerializedName("results")
    val TVShows: List<TVShow>?,

    )