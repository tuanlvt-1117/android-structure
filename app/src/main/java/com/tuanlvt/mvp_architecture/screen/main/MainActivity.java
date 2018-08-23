package com.tuanlvt.mvp_architecture.screen.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.tuanlvt.mvp_architecture.R;
import com.tuanlvt.mvp_architecture.data.model.Movie;
import com.tuanlvt.mvp_architecture.data.source.MovieRepository;
import com.tuanlvt.mvp_architecture.data.source.local.MovieLocalDataSource;
import com.tuanlvt.mvp_architecture.data.source.remote.MovieRemoteDataSource;
import com.tuanlvt.mvp_architecture.screen.main.adapter.MainAdapter;
import com.tuanlvt.mvp_architecture.utils.OnItemRecyclerViewClickListener;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements MainContract.View, OnItemRecyclerViewClickListener<Movie> {

    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_movie);
        recyclerView.setHasFixedSize(true);
        mAdapter = new MainAdapter(this);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemRecyclerViewClickListener(this);
    }

    private void initData() {
        MovieRemoteDataSource remoteDataSource = MovieRemoteDataSource.getsInstance();
        MovieLocalDataSource localDataSource = MovieLocalDataSource.getsInstance();
        MovieRepository repository =
                MovieRepository.getsInstance(remoteDataSource, localDataSource);
        MainContract.Presenter presenter = new MainPresenter(repository);
        presenter.setView(this);
        presenter.getMovie();
    }

    @Override
    public void onGetDataSuccess(List<Movie> movieList) {
        if (movieList != null) {
            mAdapter.updateData(movieList);
        }
    }

    @Override
    public void onError(Exception exception) {
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClickListener(Movie item) {
        Toast.makeText(this, item.getTitile(), Toast.LENGTH_SHORT).show();
    }
}
