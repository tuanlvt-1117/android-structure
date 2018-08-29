package com.tuanlvt.mvp_architecture.data.source.remote.api;

import com.tuanlvt.mvp_architecture.data.model.BaseResponse;
import com.tuanlvt.mvp_architecture.data.model.Movie;
import com.tuanlvt.mvp_architecture.utils.Constant;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 24/08/2018.
 * tantuan127@gmail.com
 */
public interface Api {

    @GET("3/movie/top_rated?" + Constant.BASE_API_KEY)
    Observable<BaseResponse<List<Movie>>> getData(@Query("page") int page);
}
