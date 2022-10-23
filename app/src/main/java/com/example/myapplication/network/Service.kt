package com.example.myapplication.network

import com.example.myapplication.common.ApiUrl
import com.example.myapplication.dto.image.ResponseImages
import com.example.myapplication.dto.moviedetail.MovieDetail
import com.example.myapplication.dto.movies.ResponseMovieList
import com.example.myapplication.dto.trailer.ResponseTrailerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET(ApiUrl.MOVIE_LIST)
    fun getVideos(@Query("q") q: String): Call<ResponseMovieList>

    @GET(ApiUrl.MOVIE_DETAIL)
    fun getMovieDetail(@Query("tconst") id: String): Call<MovieDetail>

    @GET(ApiUrl.GET_IMAGES)
    fun getImages(@Query("tconst") id : String,
                  @Query("limit") limit: Int? = ApiUrl.LIMIT_FOR_ITEMS
    ): Call<ResponseImages>

    @GET(ApiUrl.GET_TRAILER_LIST)
    fun getTrailers(@Query("tconst") id : String,
        @Query("limit") limit: Int? = ApiUrl.LIMIT_FOR_ITEMS,
        @Query("region") region: String? = ApiUrl.REGION_DEFAULT
    ): Call<ResponseTrailerList>

}