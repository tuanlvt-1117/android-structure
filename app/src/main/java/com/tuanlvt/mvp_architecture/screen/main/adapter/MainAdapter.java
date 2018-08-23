package com.tuanlvt.mvp_architecture.screen.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.tuanlvt.mvp_architecture.R;
import com.tuanlvt.mvp_architecture.data.model.Movie;
import com.tuanlvt.mvp_architecture.utils.Constant;
import com.tuanlvt.mvp_architecture.utils.OnItemRecyclerViewClickListener;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 23/08/2018.
 * tantuan127@gmail.com
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context mContext;
    private List<Movie> mMovieList;
    private OnItemRecyclerViewClickListener<Movie> mOnItemRecyclerViewClickListener;

    public MainAdapter(@NonNull Context context) {
        mContext = context;
        mMovieList = new ArrayList<>();
    }

    public void updateData(List<Movie> movies) {
        mMovieList.clear();
        mMovieList.addAll(movies);
        notifyDataSetChanged();
    }

    public void setOnItemRecyclerViewClickListener(
            OnItemRecyclerViewClickListener<Movie> onItemRecyclerViewClickListener) {
        mOnItemRecyclerViewClickListener = onItemRecyclerViewClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_movie, parent, false);
        return new ViewHolder(mContext, view, mMovieList, mOnItemRecyclerViewClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindViewData(mMovieList.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovieList != null ? mMovieList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Context mContext;
        private List<Movie> mMovieList;
        private CircleImageView mCircleImageViewMovie;
        private TextView mTextTitle, mTextContent, mTextRating;
        private OnItemRecyclerViewClickListener<Movie> mListener;

        ViewHolder(Context context, View itemView, List<Movie> movieList,
                OnItemRecyclerViewClickListener<Movie> listener) {
            super(itemView);
            mContext = context;
            mListener = listener;
            mMovieList = movieList;

            mCircleImageViewMovie = itemView.findViewById(R.id.image_circle_movie);
            mTextContent = itemView.findViewById(R.id.text_content_movie);
            mTextRating = itemView.findViewById(R.id.text_rating);
            mTextTitle = itemView.findViewById(R.id.text_title_movie);
        }

        void bindViewData(Movie movie) {
            mTextTitle.setText(movie.getTitile());
            mTextRating.setText(String.valueOf(movie.getVote()));
            mTextContent.setText(movie.getOriginalTitle());
            getImageCircle(movie);
        }

        private void getImageCircle(Movie movie) {
            Glide.with(mContext)
                    .load(Constant.BASE_URL_IMAGE + movie.getUrlImage())
                    .into(mCircleImageViewMovie);
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClickListener(mMovieList.get(getAdapterPosition()));
        }
    }
}
