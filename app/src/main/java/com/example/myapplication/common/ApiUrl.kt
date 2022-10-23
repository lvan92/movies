package com.example.myapplication.common

object ApiUrl {
    const val MOVIE_LIST: String = "/auto-complete"
    const val MOVIE_DETAIL: String = "/title/get-details"
    const val GET_IMAGES: String = "/title/get-images"
    const val LIMIT_FOR_ITEMS: Int = 10
    const val GET_TRAILER_LIST: String = "/title/get-videos"
    const val REGION_DEFAULT: String = "US"
}

object Header {
    const val HOST: String = "X-RapidAPI-Host"
    const val KEY: String = "X-RapidAPI-Key"
}
