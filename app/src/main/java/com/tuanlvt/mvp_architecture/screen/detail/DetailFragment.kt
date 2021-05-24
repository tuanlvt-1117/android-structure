package com.tuanlvt.mvp_architecture.screen.detail

import android.view.View
import androidx.core.os.bundleOf
import com.tuanlvt.mvp_architecture.R
import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.utils.base.BaseFragment
import com.tuanlvt.mvp_architecture.utils.ext.loadImageCircleWithUrl
import com.tuanlvt.mvp_architecture.utils.ext.loadImageWithUrl
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailFragment : BaseFragment() {

    private var movie: Movie? = null

    override fun getLayoutResourceId() = R.layout.fragment_detail

    override fun initView(view: View) {
        view.buttonImageBack.setOnClickListener { fragmentManager?.popBackStack() }
    }

    override fun initData() {
        arguments?.run {
            movie = getParcelable(ARGUMENT_MOVIE)
        }
        movie?.apply {
            imageBackDrop.loadImageWithUrl(backDropImage)
            imageMovie.loadImageCircleWithUrl(urlImage)
            textTitle.text = title
            textDescription.text = overView
            textRatting.text = vote.toString()
            textTotalReview.text = voteCount.toString()
        }
    }

    companion object {
        const val ARGUMENT_MOVIE = "ARGUMENT_MOVIE"

        fun newInstance(movie: Movie?) = DetailFragment().apply {
            arguments = bundleOf(ARGUMENT_MOVIE to movie)
        }
    }
}
