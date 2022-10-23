package com.example.myapplication.dto.image

data class ImageRelated(
    val caption: String?,
    val createdOn: String?,
    val height: Int?,
    val id: String?,
    val relatedNames: List<RelatedName>?,
    val relatedTitles: List<RelatedTitle>?,
    val source: String?,
    val type: String?,
    val url: String,
    val width: Int?
)