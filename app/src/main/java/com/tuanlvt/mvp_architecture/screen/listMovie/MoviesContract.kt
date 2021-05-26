package com.tuanlvt.mvp_architecture.screen.listMovie

import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.utils.BasePresenter

class MoviesContract {
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
