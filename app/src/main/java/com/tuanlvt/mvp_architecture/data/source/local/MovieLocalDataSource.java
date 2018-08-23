package com.tuanlvt.mvp_architecture.data.source.local;

import com.tuanlvt.mvp_architecture.data.source.MovieDataSource;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 23/08/2018.
 * tantuan127@gmail.com
 */
public class MovieLocalDataSource implements MovieDataSource.LocalDataSource {
    private static MovieLocalDataSource sInstance;

    public static MovieLocalDataSource getsInstance() {
        if (sInstance == null) {
            sInstance = new MovieLocalDataSource();
        }
        return sInstance;
    }
}
