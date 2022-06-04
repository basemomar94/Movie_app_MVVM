package com.tarek.movieappmvvm.models

import android.os.Parcelable


data class Result(
    val page: Int,
    val results: MutableList<Movie>,
    val total_pages: Int,
    val total_results: Int
)