package com.example.myapplication.dto.image

import com.google.gson.annotations.SerializedName

data class ResponseImages(
    @SerializedName("@type")
    val type: String,
    val images: List<ImageRelated>,
    val totalImageCount: Int
)