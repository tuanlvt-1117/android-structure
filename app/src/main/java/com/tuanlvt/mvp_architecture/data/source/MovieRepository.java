package com.tuanlvt.mvp_architecture.data.source;

import com.tuanlvt.mvp_architecture.data.model.Movie;
import com.tuanlvt.mvp_architecture.data.source.remote.OnFetchDataJsonListener;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 23/08/2018.
 * tantuan127@gmail.com
 */
public class MovieRepository {
    private static MovieRepository sInstance;
    private MovieDataSource.RemoteDataSource mRemoteDataSource;
    private MovieDataSource.LocalDataSource mLocalDataSource;

    private MovieRepository(MovieDataSource.RemoteDataSource remoteDataSource,
            MovieDataSource.LocalDataSource localDataSource) {
        mRemoteDataSource = remoteDataSource;
        mLocalDataSource = localDataSource;
    }

    public static MovieRepository getsInstance(MovieDataSource.RemoteDataSource remoteDataSource,
            MovieDataSource.LocalDataSource localDataSource) {
        if (sInstance == null) {
            sInstance = new MovieRepository(remoteDataSource, localDataSource);
        }
        return sInstance;
    }

    public void getData(OnFetchDataJsonListener<Movie> listener) {
        mRemoteDataSource.getData(listener);
    }
}
