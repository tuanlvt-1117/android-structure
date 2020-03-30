package com.tuanlvt.mvp_architecture.screen.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.tuanlvt.mvp_architecture.R
import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.utils.Constant
import com.tuanlvt.mvp_architecture.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.item_layout_movie.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder?>() {
    private val movies = mutableListOf<Movie>()
    private var onItemClickListener: OnItemRecyclerViewClickListener<Movie>? = null

    fun updateData(movies: MutableList<Movie>?) {
        movies?.let {
            this.movies.clear()
            this.movies.addAll(movies)
            notifyDataSetChanged()
        }
    }

    fun registerItemRecyclerViewClickListener(
            onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<Movie>?) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout_movie, parent, false)
        return ViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewData(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ViewHolder(itemView: View?, private val itemListener: OnItemRecyclerViewClickListener<Movie>?) :
            RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var listener: OnItemRecyclerViewClickListener<Movie>? = null

        fun bindViewData(movie: Movie) {
            itemView.textViewTitle.text = movie.title
            itemView.textViewRatting.text = movie.vote.toString()
            itemView.textViewContent.text = movie.originalTitle
            itemView.setOnClickListener(this)
            listener = itemListener
            getImageCircle(movie)
        }

        private fun getImageCircle(movie: Movie) {
            Glide.with(itemView.context)
                    .load(Constant.BASE_URL_IMAGE + movie.urlImage)
                    .into(itemView.imageMovie)
        }

        override fun onClick(v: View?) {
            listener?.onItemClickListener(movies[adapterPosition])
        }
    }
}
