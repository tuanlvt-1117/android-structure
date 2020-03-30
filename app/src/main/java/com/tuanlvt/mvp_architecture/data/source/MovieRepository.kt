package com.tuanlvt.mvp_architecture.data.source

import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.data.source.local.MovieLocalDataSource
import com.tuanlvt.mvp_architecture.data.source.remote.MovieRemoteDataSource
import com.tuanlvt.mvp_architecture.data.source.remote.OnFetchDataJsonListener

class MovieRepository private constructor(private val remoteDataSource: MovieDataSource.Remote?,
                                          private val localDataSource: MovieDataSource.Local?) {

    private object HOLDER {
        val INSTANCE = MovieRepository(
                remoteDataSource = MovieRemoteDataSource.instance,
                localDataSource = MovieLocalDataSource.instance)
    }

    fun getData(listener: OnFetchDataJsonListener<Movie>) {
        remoteDataSource?.getMovies(listener)
    }

    companion object {
        val instance: MovieRepository by lazy { HOLDER.INSTANCE }
    }
}
