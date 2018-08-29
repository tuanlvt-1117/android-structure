package com.tuanlvt.mvp_architecture.screen.main;

import com.tuanlvt.mvp_architecture.data.model.BaseResponse;
import com.tuanlvt.mvp_architecture.data.model.Movie;
import com.tuanlvt.mvp_architecture.data.source.MovieRepository;
import com.tuanlvt.mvp_architecture.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 24/08/2018.
 * tantuan127@gmail.com
 */
public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private MovieRepository mRepository;
    private CompositeDisposable mCompositeDisposable;
    private SchedulerProvider mSchedulerProvider;

    MainPresenter(MovieRepository repository, SchedulerProvider schedulerProvider) {
        mRepository = repository;
        mSchedulerProvider = schedulerProvider;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }

    @Override
    public void setView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void getMovie() {
        Disposable disposable = mRepository.getData()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Consumer<BaseResponse<List<Movie>>>() {
                    @Override
                    public void accept(BaseResponse<List<Movie>> listBaseResponse) {
                        mView.onGetDataSuccess(listBaseResponse.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        mView.onError(throwable);
                    }
                });
        mCompositeDisposable.add(disposable);
    }
}
