package com.example.myapplication.dto.movies

import com.google.gson.annotations.SerializedName

data class ResponseMovieList(
    @SerializedName("d")
    val result: List<MovieItem>,
    val q: String,
    val v: Int
)