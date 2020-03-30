package com.tuanlvt.mvp_architecture.data.source.local

import com.tuanlvt.mvp_architecture.data.source.MovieDataSource

class MovieLocalDataSource : MovieDataSource.Local {

    private object Holder {
        val INSTANCE = MovieLocalDataSource()
    }

    companion object {
        val instance: MovieLocalDataSource by lazy { Holder.INSTANCE }
    }
}
