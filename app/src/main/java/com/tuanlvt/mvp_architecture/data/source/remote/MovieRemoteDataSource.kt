package com.tuanlvt.mvp_architecture.data.source.remote

import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.data.model.MovieEntry
import com.tuanlvt.mvp_architecture.data.source.MovieDataSource
import com.tuanlvt.mvp_architecture.data.source.remote.fetchjson.GetJsonFromUrl
import com.tuanlvt.mvp_architecture.utils.Constant

class MovieRemoteDataSource : MovieDataSource.Remote {
    private var baseUrl = Constant.BASE_URL + Constant.BASE_API_KEY + Constant.BASE_LANGUAGE

    private object Holder {
        val INSTANCE = MovieRemoteDataSource()
    }

    override fun getMovies(listener: OnFetchDataJsonListener<MutableList<Movie>>) {
        GetJsonFromUrl(listener, MovieEntry.MOVIE).execute(baseUrl + Constant.BASE_PAGE)
    }

    companion object {
        val instance: MovieRemoteDataSource by lazy { Holder.INSTANCE }
    }
}
