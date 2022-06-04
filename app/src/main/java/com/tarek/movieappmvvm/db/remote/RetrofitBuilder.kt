package com.tarek.movieappmvvm.db.remote

import com.tarek.movieappmvvm.utilities.CONSTANTS
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {


    fun getRetrofitBuilder(): Retrofit {
        return Retrofit.Builder().baseUrl(CONSTANTS.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}