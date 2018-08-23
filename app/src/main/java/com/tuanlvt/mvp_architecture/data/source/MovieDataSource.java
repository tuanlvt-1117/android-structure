package com.tuanlvt.mvp_architecture.data.source;

import com.tuanlvt.mvp_architecture.data.model.Movie;
import com.tuanlvt.mvp_architecture.data.source.remote.OnFetchDataJsonListener;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 23/08/2018.
 * tantuan127@gmail.com
 */
public interface MovieDataSource {
    /**
     * Local
     */
    interface LocalDataSource {

    }

    /**
     * Remote
     */
    interface RemoteDataSource {
        void getData(OnFetchDataJsonListener<Movie> listener);
    }
}
