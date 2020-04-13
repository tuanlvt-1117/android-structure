package com.tuanlvt.mvp_architecture.screen.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.tuanlvt.mvp_architecture.R
import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.data.source.MovieRepository
import com.tuanlvt.mvp_architecture.screen.main.adapter.MainAdapter
import com.tuanlvt.mvp_architecture.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, OnItemRecyclerViewClickListener<Movie> {

    private val adapter: MainAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initView() {
        recyclerViewMovie.setHasFixedSize(true)
        recyclerViewMovie.adapter = adapter
        adapter.registerItemRecyclerViewClickListener(this)
    }

    private fun initData() {
        val presenter = MainPresenter(MovieRepository.instance)
        presenter.setView(this)
        presenter.onStart()
    }

    override fun onGetMoviesSuccess(movies: MutableList<Movie>) {
        adapter.updateData(movies)
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(this, exception?.message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClickListener(item: Movie?) {
        Toast.makeText(this, item?.title, Toast.LENGTH_SHORT).show()
    }
}
