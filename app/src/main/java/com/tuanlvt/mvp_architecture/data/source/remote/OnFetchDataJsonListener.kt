package com.tuanlvt.mvp_architecture.data.source.remote

interface OnDataResultListener<T> {
    fun onSuccess(data: T)
    fun onError(exception: Exception?)
}
