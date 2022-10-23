package com.example.myapplication.dto.image

data class RelatedTitle(
    val episode: Int,
    val id: String,
    val image: ImageX,
    val season: Int,
    val title: String,
    val titleType: String,
    val year: Int
)