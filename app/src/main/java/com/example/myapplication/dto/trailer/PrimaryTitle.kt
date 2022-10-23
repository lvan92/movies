package com.example.myapplication.dto.trailer

data class PrimaryTitle(
    val episode: Int,
    val id: String,
    val image: Image,
    val season: Int,
    val title: String,
    val titleType: String,
    val year: Int
)