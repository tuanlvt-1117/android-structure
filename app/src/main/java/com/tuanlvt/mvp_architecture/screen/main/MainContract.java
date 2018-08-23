package com.tuanlvt.mvp_architecture.screen.main;

import com.tuanlvt.mvp_architecture.data.model.Movie;
import com.tuanlvt.mvp_architecture.utils.BasePresenter;
import java.util.List;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 22/08/2018.
 * tantuan127@gmail.com
 */
public interface MainContract {
    /**
     * View
     */
    interface View {
        void onGetDataSuccess(List<Movie> movieList);

        void onError(Exception exception);
    }

    /**
     * Presenter
     */
    interface Presenter extends BasePresenter<View> {
        void getMovie();
    }
}
