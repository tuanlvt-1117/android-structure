package com.tuanlvt.mvp_architecture.data.source.remote;

import java.util.List;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 23/08/2018.
 * tantuan127@gmail.com
 */
public interface OnFetchDataJsonListener<T> {

    void onSuccess(List<T> data);

    void onError(Exception e);
}
