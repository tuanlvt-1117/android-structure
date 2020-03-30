package com.tuanlvt.mvp_architecture.data.source.remote.fetchjson

import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.data.source.remote.OnFetchDataJsonListener
import com.tuanlvt.mvp_architecture.utils.Constant

class GetDataJson(private val listener: OnFetchDataJsonListener<Movie>) {
    fun getMovies() {
        val url = (Constant.BASE_URL
                + Constant.BASE_API_KEY
                + Constant.BASE_LANGUAGE
                + Constant.BASE_PAGE)
        GetJsonFromUrl(listener).execute(url)
    }
}
