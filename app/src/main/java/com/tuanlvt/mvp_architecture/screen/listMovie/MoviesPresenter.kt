package com.tuanlvt.mvp_architecture.screen.listMovie

import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.data.source.MovieRepository
import com.tuanlvt.mvp_architecture.data.source.remote.OnDataResultListener

class MoviesPresenter internal constructor(private val repository: MovieRepository?) : MoviesContract.Presenter {

    private var view: MoviesContract.View? = null

    override fun onStart() {
        getMovies()
    }

    override fun onStop() {
        view = null
    }

    override fun setView(view: MoviesContract.View?) {
        this.view = view
    }

    override fun getMovies() {
        repository?.getMovie(object : OnDataResultListener<MutableList<Movie>> {
            override fun onSuccess(data: MutableList<Movie>) {
                view?.onGetMoviesSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }
        })
    }
}
