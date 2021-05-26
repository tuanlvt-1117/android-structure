package com.tuanlvt.mvp_architecture.screen.listMovie

import android.view.View
import android.widget.Toast
import com.tuanlvt.mvp_architecture.R
import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.data.source.MovieRepository
import com.tuanlvt.mvp_architecture.data.source.local.MovieLocalDataSource
import com.tuanlvt.mvp_architecture.data.source.remote.MovieRemoteDataSource
import com.tuanlvt.mvp_architecture.screen.detail.DetailFragment
import com.tuanlvt.mvp_architecture.screen.listMovie.adapter.MoviesAdapter
import com.tuanlvt.mvp_architecture.utils.OnItemRecyclerViewClickListener
import com.tuanlvt.mvp_architecture.utils.base.BaseFragment
import com.tuanlvt.mvp_architecture.utils.ext.addFragment
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.fragment_movies.view.*

class MoviesFragment : BaseFragment(), MoviesContract.View, OnItemRecyclerViewClickListener<Movie> {

    private val adapter: MoviesAdapter by lazy { MoviesAdapter() }

    override fun getLayoutResourceId() = R.layout.fragment_movies

    override fun initView(view: View) {
        view.recyclerViewMovie.apply {
            adapter = this@MoviesFragment.adapter
        }
        adapter.registerItemRecyclerViewClickListener(this)
    }

    override fun initData() {
        MoviesPresenter(MovieRepository.getInstance(
                MovieRemoteDataSource.getInstance(),
                MovieLocalDataSource.getInstance())).run {
            setView(this@MoviesFragment)
            onStart()
        }
    }

    override fun onGetMoviesSuccess(movies: MutableList<Movie>) {
        adapter.updateData(movies)
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(context, exception?.message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClickListener(item: Movie?) {
        addFragment(R.id.layoutContainer, DetailFragment.newInstance(item))
    }

    companion object {
        fun newInstance() = MoviesFragment()
    }
}
