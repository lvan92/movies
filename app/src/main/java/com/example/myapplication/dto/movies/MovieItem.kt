package com.example.myapplication.dto.movies

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieItem(
    @SerializedName("i")
    val poster: Poster,
    val id: String?,
    @SerializedName("l")
    val name: String?,
    val q: String?,
    val rank: Int?,
    @SerializedName("s")
    val description: String?,
    val v: List<V>?,
    val vt: Int?,
    val y: Int?,
    val yr: String?
): Serializable