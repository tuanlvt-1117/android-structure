package com.tuanlvt.mvp_architecture.screen.main

import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.data.source.MovieRepository
import com.tuanlvt.mvp_architecture.data.source.remote.OnFetchDataJsonListener
import com.tuanlvt.mvp_architecture.screen.main.MainContract.Presenter

class MainPresenter internal constructor(private val repository: MovieRepository?) : Presenter {

    private var view: MainContract.View? = null

    override fun onStart() {}

    override fun onStop() {}

    override fun setView(view: MainContract.View?) {
        this.view = view
    }

    override fun getMovies() {
        repository?.getData(object : OnFetchDataJsonListener<Movie> {
            override fun onSuccess(data: MutableList<Movie>) {
                view?.onGetMoviesSuccess(data)
            }

            override fun onError(e: Exception?) {
                view?.onError(e)
            }
        })
    }
}
