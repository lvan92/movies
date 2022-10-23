package com.example.myapplication.dto.trailer

data class TrailerItem(
    val audioLanguage: String?,
    val contentType: String?,
    val description: String?,
    val durationInSeconds: Int?,
    val id: String?,
    val image: ImageOfTrailer,
    val parentTitle: ParentTitle?,
    val primaryTitle: PrimaryTitle?,
    val title: String
)