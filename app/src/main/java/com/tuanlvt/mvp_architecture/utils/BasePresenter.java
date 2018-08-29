package com.tuanlvt.mvp_architecture.utils;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 24/08/2018.
 * tantuan127@gmail.com
 */
public interface BasePresenter<T> {
    void onStart();

    void onStop();

    void setView(T view);
}
