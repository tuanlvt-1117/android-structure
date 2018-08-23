package com.tuanlvt.mvp_architecture.data.source.remote.fetchjson;

import com.tuanlvt.mvp_architecture.data.model.Movie;
import com.tuanlvt.mvp_architecture.data.source.remote.OnFetchDataJsonListener;
import com.tuanlvt.mvp_architecture.utils.Constant;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 23/08/2018.
 * tantuan127@gmail.com
 */
public class GetDataJson {

    private OnFetchDataJsonListener<Movie> mListener;

    public GetDataJson(OnFetchDataJsonListener<Movie> listener) {
        mListener = listener;
    }

    public void getData() {
        String url = Constant.BASE_URL
                + Constant.BASE_API_KEY
                + Constant.BASE_LANGUAGE
                + Constant.BASE_PAGE;
        new GetJsonFromUrl(mListener).execute(url);
    }
}
