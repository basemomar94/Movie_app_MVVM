package com.tarek.movieappmvvm.utilities

import com.tarek.movieappmvvm.models.Status


class NetworkState(val status: Status, val msg: String) {

    companion object {
        val LOADED: NetworkState = NetworkState(Status.SUCCESS,"Success")
        val LOADING: NetworkState = NetworkState(Status.RUNNING,"Loading")
        val ERROR: NetworkState = NetworkState(Status.RUNNING,"Failed")

    }
}