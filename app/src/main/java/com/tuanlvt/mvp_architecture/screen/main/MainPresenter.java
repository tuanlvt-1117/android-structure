package com.tuanlvt.mvp_architecture.screen.main;

import com.tuanlvt.mvp_architecture.data.model.Movie;
import com.tuanlvt.mvp_architecture.data.source.MovieRepository;
import com.tuanlvt.mvp_architecture.data.source.remote.OnFetchDataJsonListener;
import java.util.List;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 22/08/2018.
 * tantuan127@gmail.com
 */
public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private MovieRepository mRepository;

    MainPresenter(MovieRepository repository) {
        mRepository = repository;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void setView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void getMovie() {
        mRepository.getData(new OnFetchDataJsonListener<Movie>() {
            @Override
            public void onSuccess(List<Movie> data) {
                mView.onGetDataSuccess(data);
            }

            @Override
            public void onError(Exception e) {
                mView.onError(e);
            }
        });
    }
}
