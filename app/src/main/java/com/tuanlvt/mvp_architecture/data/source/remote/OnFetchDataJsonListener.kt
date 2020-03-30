package com.tuanlvt.mvp_architecture.data.source.remote

interface OnFetchDataJsonListener<T> {
    fun onSuccess(data: MutableList<T>)
    fun onError(e: Exception?)
}
