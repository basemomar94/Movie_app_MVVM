package com.tarek.movieappmvvm.repositories

import androidx.lifecycle.MutableLiveData
import com.tarek.movieappmvvm.db.remote.ServiceApi
import com.tarek.movieappmvvm.models.Movie
import com.tarek.movieappmvvm.models.MovieDetails
import com.tarek.movieappmvvm.models.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class RemoteRepoImp(private val serviceAPI: ServiceApi) : RemoteRepo {


    override suspend fun getAllMovies(apiKey: String, page: Int): Response<Result> =
        withContext(Dispatchers.IO) {
            serviceAPI.getAllMovies(apiKey, page)
        }

    override suspend fun getMovieDetails(movieId: Int, apiKey: String): Response<MovieDetails> =
        withContext(Dispatchers.IO) {
            serviceAPI.getMovieDetails(movieId, apiKey)
        }


}