package com.tuanlvt.mvp_architecture.data.source

import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.data.source.local.MovieLocalDataSource
import com.tuanlvt.mvp_architecture.data.source.remote.MovieRemoteDataSource
import com.tuanlvt.mvp_architecture.data.source.remote.OnFetchDataJsonListener

class MovieRepository private constructor(private val remote: MovieDataSource.Remote,
                                          private val local: MovieDataSource.Local) {

    private object Holder {
        val INSTANCE = MovieRepository(
                remote = MovieRemoteDataSource.instance,
                local = MovieLocalDataSource.instance)
    }

    fun getMovie(listener: OnFetchDataJsonListener<MutableList<Movie>>) {
        remote.getMovies(listener)
    }

    companion object {
        val instance: MovieRepository by lazy { Holder.INSTANCE }
    }
}
