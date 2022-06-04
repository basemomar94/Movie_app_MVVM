package com.tarek.movieappmvvm.db.remote

import com.tarek.movieappmvvm.models.MovieDetails
import com.tarek.movieappmvvm.models.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApi {


    @GET("movie/popular")
    suspend fun getAllMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Response<Result>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId:Int,
        @Query("api_key") apiKey: String
    ) : Response<MovieDetails>
}