package com.tarek.movieappmvvm.repositories

import com.tarek.movieappmvvm.models.MovieDetails
import com.tarek.movieappmvvm.models.Result
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.Query

interface RemoteRepo {

    suspend fun getAllMovies(
        apiKey: String,
        page: Int
    ): Response<Result>

    suspend fun getMovieDetails(
        movieId: Int,
        apiKey: String

    ): Response<MovieDetails>
}