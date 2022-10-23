package com.example.myapplication.dto.trailer

import com.google.gson.annotations.SerializedName

data class Resource(
    @SerializedName("@type")
    val type: String,
    val id: String,
    val image: Image,
    val size: Int,
    val title: String,
    val titleType: String,
    val videoCounts: List<VideoCount>,
    val videos: List<TrailerItem>,
    val year: Int
)