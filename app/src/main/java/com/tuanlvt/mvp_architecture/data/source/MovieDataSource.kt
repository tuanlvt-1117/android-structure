package com.tuanlvt.mvp_architecture.data.source

import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.data.source.remote.OnDataResultListener

interface MovieDataSource {
    /**
     * Local
     */
    interface Local

    /**
     * Remote
     */
    interface Remote {
        fun getMovies(listener: OnDataResultListener<MutableList<Movie>>)
    }
}
