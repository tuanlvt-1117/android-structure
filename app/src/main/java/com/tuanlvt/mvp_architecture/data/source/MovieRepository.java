package com.tuanlvt.mvp_architecture.data.source;

import com.tuanlvt.mvp_architecture.data.model.BaseResponse;
import com.tuanlvt.mvp_architecture.data.model.Movie;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 24/08/2018.
 * tantuan127@gmail.com
 */
public class MovieRepository {

    private MovieDataSource.RemoteDataSource mRemoteDataSource;
    private MovieDataSource.LocalDataSource mLocalDataSource;

    public MovieRepository(MovieDataSource.RemoteDataSource remoteDataSource,
            MovieDataSource.LocalDataSource localDataSource) {
        mRemoteDataSource = remoteDataSource;
        mLocalDataSource = localDataSource;
    }

    public Observable<BaseResponse<List<Movie>>> getData() {
        return mRemoteDataSource.getData();
    }
}
