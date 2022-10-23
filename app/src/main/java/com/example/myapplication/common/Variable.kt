package com.example.myapplication.common

import com.example.myapplication.dto.image.ImageRelated
import com.example.myapplication.dto.moviedetail.Image
import com.example.myapplication.dto.moviedetail.MovieDetail
import com.example.myapplication.dto.movies.MovieItem
import com.example.myapplication.dto.movies.Poster
import com.example.myapplication.dto.trailer.ImageOfTrailer
import com.example.myapplication.dto.trailer.TrailerItem

object Variable {
    const val API_KEY: String = "31cc0f6082msh1568b0a7ff7a35bp1b0589jsnd55d0038f3c9"
    const val API_HOST: String = "imdb8.p.rapidapi.com"
    const val BASE_URL: String = "https://imdb8.p.rapidapi.com"
    val RATING_VALUE: List<String> = listOf("1.0","1.5","2.0","2.5","3.0","3.5","4.0","4.5","5.0")
}
fun createDummyDataMovies (n: Int): List<MovieItem> {
    val dummyMovie = ArrayList<MovieItem>()
    for(i in 1..n) {
        val movie =
        MovieItem(
            Poster(1000,"url",650),
            "tt2212",
            "Movie $i",
            "movie",
            1500,
            "Hi movie $i",
            null,
            null,
            null,
            null)
        dummyMovie.add(movie)
    }
    return dummyMovie
}

fun createDummyDataDetailMovie () : MovieDetail {
    return MovieDetail(
        "Movie",
        "ttt",
        Image(1000,"id","url", 650),
        null,
        1,
        120,
        null,
        null,
        "Movie",
        "Video",
        2020
    )
}

fun createDummyDataImageRelated (): List<ImageRelated> {
    val dummyImageRelated = ArrayList<ImageRelated>()
    for (i in 1..3) {
        dummyImageRelated.add(
            ImageRelated(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            "url",
            null
        )
        )
    }
    return dummyImageRelated
}

fun createDummyDataTrailers(): List<TrailerItem> {
    val dummyTrailer = ArrayList<TrailerItem>()
    for (i in 1..3) {
        dummyTrailer.add(TrailerItem(
            null,
            null,
            null,
            null,
            "id",
            ImageOfTrailer(100,"url", 650 ),
            null,
            null,
            "Trailer $i"
        ))
    }

    return dummyTrailer
}

