package com.tuanlvt.mvp_architecture.screen.listMovie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuanlvt.mvp_architecture.R
import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.utils.OnItemRecyclerViewClickListener
import com.tuanlvt.mvp_architecture.utils.ext.loadImageCircleWithUrl
import kotlinx.android.synthetic.main.item_layout_movie.view.*

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder?>() {
    private val movies = mutableListOf<Movie>()
    private var onItemClickListener: OnItemRecyclerViewClickListener<Movie>? = null

    fun updateData(movies: MutableList<Movie>?) {
        movies?.let {
            this.movies.clear()
            this.movies.addAll(it)
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

    override fun getItemCount() = movies.size

    class ViewHolder(itemView: View?, private val itemListener: OnItemRecyclerViewClickListener<Movie>?) :
            RecyclerView.ViewHolder(itemView!!), View.OnClickListener {

        private var listener: OnItemRecyclerViewClickListener<Movie>? = null
        private var movieData: Movie? = null

        fun bindViewData(movie: Movie) = with(itemView) {
            movie.let {
                textViewTitle.text = it.title
                textViewRatting.text = it.vote.toString()
                textViewContent.text = it.originalTitle
                imageMovie.loadImageCircleWithUrl(it.urlImage)
                setOnClickListener(this@ViewHolder)
                listener = itemListener
                movieData = it
            }
        }

        override fun onClick(v: View?) {
            listener?.onItemClickListener(movieData)
        }
    }
}
