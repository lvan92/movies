package com.example.myapplication.dto.image

data class RelatedName(
    val akas: List<String>,
    val disambiguation: String,
    val id: String,
    val image: ImageX,
    val legacyNameText: String,
    val name: String
)