package com.tarek.movieappmvvm.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tarek.movieappmvvm.db.remote.RetrofitBuilder
import com.tarek.movieappmvvm.db.remote.ServiceApi
import com.tarek.movieappmvvm.models.Movie
import com.tarek.movieappmvvm.models.MovieDetails
import com.tarek.movieappmvvm.repositories.RemoteRepoImp
import com.tarek.movieappmvvm.utilities.CONSTANTS
import kotlinx.coroutines.launch
import retrofit2.create

class HomeViewModel : ViewModel() {
    private val api = RetrofitBuilder.getRetrofitBuilder().create(ServiceApi::class.java)
    private val remoteRepo = RemoteRepoImp(api)
    val moviesList = MutableLiveData<MutableList<Movie>>()
    val movieDetails = MutableLiveData<MovieDetails>()


    fun getPopularMovies(key: String, page: Int) = viewModelScope.launch {
        val result = remoteRepo.getAllMovies(key, page)
        if (result.isSuccessful) {
            moviesList.postValue(result.body()?.results)
        }
    }

    fun getMovieDetails(movieId: Int, key: String) = viewModelScope.launch {
        val result = remoteRepo.getMovieDetails(movieId, key)
        println(result)
        if (result.isSuccessful) {
            movieDetails.postValue(result.body())
            println("success")

        } else {
            println(result.message())
        }
    }
}