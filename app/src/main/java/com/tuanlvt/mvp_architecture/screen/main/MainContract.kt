package com.tuanlvt.mvp_architecture.screen.main

import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.utils.BasePresenter

interface MainContract {
    /**
     * View
     */
    interface View {
        fun onGetMoviesSuccess(movies: MutableList<Movie>)
        fun onError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun getMovies()
    }
}
