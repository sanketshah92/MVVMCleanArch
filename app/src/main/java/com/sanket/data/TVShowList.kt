package com.sanket.data


import com.google.gson.annotations.SerializedName

data class TVShowList(

    @SerializedName("results")
    val TVShows: List<TVShow>?,

    )