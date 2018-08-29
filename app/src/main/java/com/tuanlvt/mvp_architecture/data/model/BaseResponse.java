package com.tuanlvt.mvp_architecture.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 24/08/2018.
 * tantuan127@gmail.com
 */
public class BaseResponse<T> {

    @SerializedName("results")
    @Expose
    private T mData;

    public BaseResponse(T data) {
        mData = data;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }
}
