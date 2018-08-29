package com.tuanlvt.mvp_architecture.data.source.remote;

import com.tuanlvt.mvp_architecture.data.model.BaseResponse;
import com.tuanlvt.mvp_architecture.data.model.Movie;
import com.tuanlvt.mvp_architecture.data.source.MovieDataSource;
import com.tuanlvt.mvp_architecture.data.source.remote.api.Api;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 24/08/2018.
 * tantuan127@gmail.com
 */
public class MovieRemoteDataSource implements MovieDataSource.RemoteDataSource {

    private Api mApi;

    public MovieRemoteDataSource(Api api) {
        mApi = api;
    }

    @Override
    public Observable<BaseResponse<List<Movie>>> getData() {
        return mApi.getData(1);
    }
}
