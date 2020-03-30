package com.tuanlvt.mvp_architecture.data.source.remote

import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.data.source.MovieDataSource
import com.tuanlvt.mvp_architecture.data.source.remote.fetchjson.GetDataJson

class MovieRemoteDataSource : MovieDataSource.Remote {

    private object HOLDER {
        val INSTANCE = MovieRemoteDataSource()
    }

    override fun getMovies(listener: OnFetchDataJsonListener<Movie>) {
        GetDataJson(listener).getMovies()
    }

    companion object {
        val instance: MovieRemoteDataSource by lazy { HOLDER.INSTANCE }
    }
}
