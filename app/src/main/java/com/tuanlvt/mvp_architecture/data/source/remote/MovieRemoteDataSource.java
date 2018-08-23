package com.tuanlvt.mvp_architecture.data.source.remote;

import com.tuanlvt.mvp_architecture.data.model.Movie;
import com.tuanlvt.mvp_architecture.data.source.MovieDataSource;
import com.tuanlvt.mvp_architecture.data.source.remote.fetchjson.GetDataJson;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 23/08/2018.
 * tantuan127@gmail.com
 */
public class MovieRemoteDataSource implements MovieDataSource.RemoteDataSource {

    private static MovieRemoteDataSource sInstance;

    public static MovieRemoteDataSource getsInstance() {
        if (sInstance == null) {
            sInstance = new MovieRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getData(OnFetchDataJsonListener<Movie> listener) {
        GetDataJson getDataJson = new GetDataJson(listener);
        getDataJson.getData();
    }
}
