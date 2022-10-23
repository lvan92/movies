package com.example.myapplication.dto.moviedetail

import com.google.gson.annotations.SerializedName

data class MovieDetail(
    @SerializedName(" @type")
    val type: String,
    val id: String,
    val image: Image,
    val nextEpisode: String?,
    val numberOfEpisodes: Int?,
    val runningTimeInMinutes: Int,
    val seriesEndYear: Int?,
    val seriesStartYear: Int?,
    val title: String,
    val titleType: String,
    val year: Int
)