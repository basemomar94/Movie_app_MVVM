package com.tarek.movieappmvvm.hilt

import com.tarek.movieappmvvm.db.remote.ServiceApi
import com.tarek.movieappmvvm.utilities.CONSTANTS
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/*

@InstallIn(SingletonComponent::class)
@Module
object HiltModules {

    @Provides
    fun provideRetrofitInterface(): ServiceApi {
        return Retrofit.Builder().baseUrl(CONSTANTS.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ServiceApi::class.java)
    }
}*/