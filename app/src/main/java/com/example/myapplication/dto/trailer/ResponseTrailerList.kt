package com.example.myapplication.dto.trailer

import com.google.gson.annotations.SerializedName

data class ResponseTrailerList(
    @SerializedName(" @meta")
    val meta: Meta,
    val resource: Resource
)