package com.tuanlvt.mvp_architecture.data.source

import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.data.source.remote.OnDataResultListener

class MovieRepository private constructor(private val remote: MovieDataSource.Remote,
                                          private val local: MovieDataSource.Local) {
    fun getMovie(listener: OnDataResultListener<MutableList<Movie>>) {
        remote.getMovies(listener)
    }

    companion object {
        private var instance: MovieRepository? = null

        fun getInstance(remote: MovieDataSource.Remote,
                        local: MovieDataSource.Local) = synchronized(this) {
            instance ?: MovieRepository(remote, local).also { instance = it }
        }
    }
}
