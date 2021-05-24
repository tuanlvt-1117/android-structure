package com.tuanlvt.mvp_architecture.data.source.local

import com.tuanlvt.mvp_architecture.data.source.MovieDataSource

class MovieLocalDataSource : MovieDataSource.Local {

    companion object {
        @Volatile
        private var instance: MovieLocalDataSource? = null

        fun getInstance() = synchronized(this) {
            instance ?: MovieLocalDataSource().also { instance = it }
        }
    }
}
