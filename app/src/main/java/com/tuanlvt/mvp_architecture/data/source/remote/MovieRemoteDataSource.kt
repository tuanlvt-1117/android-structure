package com.tuanlvt.mvp_architecture.data.source.remote

import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.data.model.MovieEntry
import com.tuanlvt.mvp_architecture.data.source.MovieDataSource
import com.tuanlvt.mvp_architecture.data.source.remote.fetchjson.GetJsonFromUrl
import com.tuanlvt.mvp_architecture.utils.Constant

class MovieRemoteDataSource : MovieDataSource.Remote {

    private var baseUrl = Constant.BASE_URL

    override fun getMovies(listener: OnDataResultListener<MutableList<Movie>>) {
        GetJsonFromUrl(listener,
                baseUrl + Constant.BASE_PAGE,
                MovieEntry.MOVIE)
    }

    companion object {
        private var instance: MovieRemoteDataSource? = null

        fun getInstance() = synchronized(this) {
            instance ?: MovieRemoteDataSource().also { instance = it }
        }
    }
}
